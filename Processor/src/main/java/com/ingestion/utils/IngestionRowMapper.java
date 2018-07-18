package com.ingestion.utils;

import java.util.List;

import com.ingestion.processor.Asset;

public class IngestionRowMapper {
	
	public Asset map(List<Object> jobData) {
		Asset job = new Asset();
		job.setTitleGroupId(jobData.get(0)!=null?jobData.get(0).toString():"");
		String sid=jobData.get(1).toString();
		if(sid.contains(".")) {
			sid=sid.substring(0,sid.length()-3);
		}
		job.setAssetSid(jobData.get(1)!=null?Long.parseLong(sid):null);
		job.setStatus(jobData.get(3)!=null?jobData.get(3).toString():"");		
		job.setPublishingStatus(jobData.get(6)!=null?jobData.get(6).toString():"");
		job.setTitle(jobData.get(8)!=null?jobData.get(8).toString():"");
		job.setSubTitle(jobData.get(9)!=null?jobData.get(9).toString():"");		
		
		return job;
	}
}
