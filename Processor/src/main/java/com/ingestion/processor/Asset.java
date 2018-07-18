package com.ingestion.processor;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Asset implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long assetSid;

	private String titleGroupId;

	private String status;

	private String publishingStatus;

	private String title;

	private String subTitle;

	public long getAssetSid() {
		return assetSid;
	}

	public void setAssetSid(long assetSid) {
		this.assetSid = assetSid;
	}

	public String getTitleGroupId() {
		return titleGroupId;
	}

	public void setTitleGroupId(String titleGroupId) {
		this.titleGroupId = titleGroupId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPublishingStatus() {
		return publishingStatus;
	}

	public void setPublishingStatus(String publishingStatus) {
		this.publishingStatus = publishingStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	@Override
	public String toString() {
		return "Asset [assetSid=" + assetSid + ", titleGroupId=" + titleGroupId + ", status=" + status
				+ ", publishingStatus=" + publishingStatus + ", title=" + title + ", subTitle=" + subTitle + "]";
	}

}
