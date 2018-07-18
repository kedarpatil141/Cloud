package com.ingestion.service;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.ingestion.model.IngestionReponse;

@Component
public class IngestionResponseTracker {

	@Autowired
	JmsTemplate messageTemplate;	
	
	@JmsListener(destination = "Ingestion.Processed.Channel")
	@SendTo("Ingestion.Completed.Channel")
	public String processSuccess(final Message ingestionJob) throws JMSException {
		System.out.println(ingestionJob);
		System.out.println(ingestionJob.getPayload().toString());
		IngestionReponse response = new Gson().fromJson((String) ingestionJob.getPayload(), IngestionReponse.class);
		switch (response.getStatus()) {
		case "SUCCESS":
			System.out.println(response.getMessageId()+" completed succesfully");
			break;
		case "COMPLETED_WITH_ERROR":
			System.out.println(response.getMessageId()+" completed with errors succesfully, with warning "+response.getWarning());
			break;
		case "FAILURE":
			System.out.println(response.getMessageId()+" faile with errors "+response.getWarning());
			messageTemplate.convertAndSend("Ingestion.Failures.Channel", new Gson().toJson(ingestionJob));
			break;

		default:
			break;
		}
		
		return ingestionJob.getPayload().toString();
	}
	
	

	

}
