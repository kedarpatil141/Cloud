package com.ingestion.controllers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.ingestion.model.IngestionJob;
import com.ingestion.model.IngestionReponse;
import com.ingestion.service.IngestionService;
import com.ingestion.websockets.SocketHandler;

@Controller
public class FileUploadController {

	private static String UPLOAD_FOLDER = "c:/repo/";

	@Autowired
	IngestionService service;

	@RequestMapping("/upload")
	public ModelAndView showUpload() {
		return new ModelAndView("upload");
	}

	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		String ingestionDetails = null;
		if (file.isEmpty()) {
			return new ModelAndView("status", "message", "Please select a file and try again");
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = file.getBytes();
			String contentPath = UPLOAD_FOLDER + file.getOriginalFilename();
			Path path = Paths.get(contentPath);
			Files.write(path, bytes);

			List<String> files = new ArrayList();
			files.add(contentPath);

			IngestionJob job = new IngestionJob(files);

			ingestionDetails = service.postIngestion(job);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("status", "message", ingestionDetails + " scheduled succesfully.");
	}

	@RequestMapping("/name")
	public SseEmitter handleRequest(String message) {

		final SseEmitter emitter = new SseEmitter();

		if (message != null) {
			try {
				emitter.send(message, MediaType.TEXT_PLAIN);
			} catch (IOException e) {
				e.printStackTrace();
			}
			emitter.complete();
		}
		return emitter;
	}

	@JmsListener(destination = "Ingestion.Completed.Channel")
	@SendTo("Ingestion.Archive.Channel")
	public String receiveMessageFromQueue(final Message ingestionJob) throws JMSException {
		String details = null;

		details = (String) ingestionJob.getPayload();

		Gson gson = new Gson();
		IngestionReponse response = gson.fromJson(details, IngestionReponse.class);

		System.out.println(" Response is " + response);
		handleRequest(response.getStatus() + " " + response.getInfo());

		/*SocketHandler handler = new SocketHandler();*/

		
		return details;
	}

}
