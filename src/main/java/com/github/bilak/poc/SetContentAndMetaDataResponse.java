package com.github.bilak.poc;

/**
 * @author lvasek.
 */
public class SetContentAndMetaDataResponse extends SetContentResponse {

	private ContentMetaData contentMetaData;

	public SetContentAndMetaDataResponse() {
	}

	public SetContentAndMetaDataResponse(MultipartFilePojo content, ContentMetaData contentMetaData) {
		super(content);
		this.contentMetaData = contentMetaData;
	}

	public SetContentAndMetaDataResponse(MultipartFilePojo content) {
		super(content);
	}

	public ContentMetaData getContentMetaData() {
		return contentMetaData;
	}

	public void setContentMetaData(ContentMetaData contentMetaData) {
		this.contentMetaData = contentMetaData;
	}
}
