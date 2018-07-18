package com.ingestion.model;

import java.io.Serializable;

public class IngestionReponse implements Serializable{

	private static final long serialVersionUID = -7979222798141780262L;
	private String messageId;
	private String status;
	private String warning;
	private String info;
	private long executionTime;	
	
	
	public IngestionReponse(String messageId, String status, String warning, String info, long executionTime) {
		super();
		this.messageId = messageId;
		this.status = status;
		this.warning = warning;
		this.info = info;
		this.executionTime = executionTime;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	@Override
	public String toString() {
		return "IngestionReponse [messageId=" + messageId + ", status=" + status + ", warning=" + warning + ", info="
				+ info + ", executionTime=" + executionTime + "]";
	}
	
	
}
