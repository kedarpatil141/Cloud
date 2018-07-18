package com.ingestion.model;

import java.io.Serializable;
import java.util.List;

public class IngestionJob implements Serializable {
	private static final long serialVersionUID = 439942179206572019L;
	
	private String jobId;
	private List<String> ingestionFiles;
	
	public IngestionJob( List<String> ingestionFiles ) {
		this.ingestionFiles=ingestionFiles;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public List<String> getIngestionFiles() {
		return ingestionFiles;
	}
	public void setIngestionFiles(List<String> ingestionFiles) {
		this.ingestionFiles = ingestionFiles;
	}
	
	
}
