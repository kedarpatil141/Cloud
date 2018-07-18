package com.ingestion.messaging;

import org.springframework.integration.annotation.MessagingGateway;

import com.ingestion.model.IngestionJob;

@MessagingGateway(defaultRequestChannel="requestCahnnel")
public interface Sender {
	public void sendMessage(IngestionJob message);
}
