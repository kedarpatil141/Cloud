package com.ingestion.model;

public class IngestionJobDTO {

	private String titleGroupId;
	private String assetSID;
	private String titleGroupName;
	
	public IngestionJobDTO() {
		
	}
	
	public String getTitleGroupId() {
		return titleGroupId;
	}
	public void setTitleGroupId(String titleGroupId) {
		this.titleGroupId = titleGroupId;
	}
	public String getAssetSID() {
		return assetSID;
	}
	public void setAssetSID(String assetSID) {
		this.assetSID = assetSID;
	}
	public String getTitleGroupName() {
		return titleGroupName;
	}
	public void setTitleGroupName(String titleGroupName) {
		this.titleGroupName = titleGroupName;
	}

	@Override
	public String toString() {
		return "IngestionJobDTO [titleGroupId=" + titleGroupId + ", assetSID=" + assetSID + ", titleGroupName="
				+ titleGroupName + "]";
	}
	
	
	
}
