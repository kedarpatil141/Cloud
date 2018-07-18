package com.ingestion.processor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.ingestion.model.IngestionJob;
import com.ingestion.model.IngestionReponse;

@Component
public class IngestionProcessor {

	@Autowired
	protected RestTemplate restTemplate;
	// INGESTION_BACKEND_SERVICE
	protected String serviceUrl = "http://INGESTION-BACKEND-SERVICE/assets/";

	@JmsListener(destination = "Ingestion.Input.Channel")
	@SendTo("Ingestion.Processed.Channel")
	public String receiveMessageFromQueue(final Message ingestionJob) throws JMSException {
		String details = null;

		details = (String) ingestionJob.getPayload();
		Gson gson = new Gson();
		IngestionJob job = gson.fromJson(details, IngestionJob.class);

		IngestionReponse response = processIngestion(job);

		return gson.toJson(response);
	}

	private IngestionReponse processIngestion(IngestionJob jobDetails) {
		long startTime = Calendar.getInstance().getTimeInMillis();

		List<Asset> assetDetailsList = new ExcelProcessor(jobDetails.getIngestionFiles().get(0)).processExcel();
		
		for (Asset asset : assetDetailsList) {
			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<Asset> entity = new HttpEntity<Asset>(asset, headers);
				
				restTemplate.exchange(serviceUrl, HttpMethod.POST, entity, Asset.class);
			} catch (Exception e) {
				//Exception Handling code goes here...
			}
		}

		long endTime = Calendar.getInstance().getTimeInMillis();
		IngestionReponse response = new IngestionReponse(jobDetails.getJobId(), "SUCCESS", null,
				"Succefully completed ingestion", endTime - startTime);

		return response;
	}

	@Bean
	@LoadBalanced
	private RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		template.setMessageConverters(getMessageConverters());

		return template;
	}

	private static List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJackson2HttpMessageConverter());
		return converters;
	}
}
