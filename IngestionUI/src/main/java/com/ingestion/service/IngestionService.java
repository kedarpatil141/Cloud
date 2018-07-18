package com.ingestion.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ingestion.model.IngestionJob;

@Service
public class IngestionService {
	@Autowired
	JmsTemplate messageTemplate;
	
	public String postIngestion(IngestionJob ingestionJob) {
		Gson gson = new Gson();
		
		ingestionJob.setJobId("Job # "+new Random().nextInt(100));
		messageTemplate.convertAndSend("Ingestion.Input.Channel",gson.toJson(ingestionJob));
		return ingestionJob.getJobId();
	}	
	
}
