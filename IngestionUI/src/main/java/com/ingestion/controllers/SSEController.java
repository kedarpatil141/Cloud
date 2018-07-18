package com.ingestion.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@RestController
public class SSEController {

	/*public static final List<SseEmitter> emitters = Collections.synchronizedList(new ArrayList<>());
	
	
	public SSEController() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sendSseEventsToUI(Calendar.getInstance().getTime().toString());
		}
	}
	

	@RequestMapping(path = "/stream", method = RequestMethod.GET)
	public SseEmitter stream() throws IOException {

		SseEmitter emitter = new SseEmitter();

		emitters.add(emitter);
		emitter.onCompletion(() -> emitters.remove(emitter));

		return emitter;
	}

	public void sendSseEventsToUI(String notification) {
		List<SseEmitter> sseEmitterListToRemove = new ArrayList<>();
		SSEController.emitters.forEach((SseEmitter emitter) -> {
			try {
				emitter.send(notification, MediaType.APPLICATION_JSON);
			} catch (IOException e) {
				emitter.complete();
				sseEmitterListToRemove.add(emitter);
				e.printStackTrace();
			}
		});
		SSEController.emitters.removeAll(sseEmitterListToRemove);
	}*/
}