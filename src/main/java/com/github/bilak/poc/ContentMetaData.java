package com.github.bilak.poc;

/**
 * @author lvasek.
 */
public class ContentMetaData {

	private String contentId;
	private String creator;

	public ContentMetaData() {
	}

	public ContentMetaData(String contentId, String creator) {
		this.contentId = contentId;
		this.creator = creator;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
