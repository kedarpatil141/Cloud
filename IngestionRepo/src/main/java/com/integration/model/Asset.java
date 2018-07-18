package com.integration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ASSETS")
@Component
public class Asset implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isbn13")
	private long assetSid;
	
	@Column(name = "title_group_id")
	private String titleGroupId;

	@Column(name = "asset_status")	
	private String status;
	
	@Column(name = "publishing_status")
	private String publishingStatus;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "sub_title")
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
