package com.github.bilak.poc;

/**
 * @author lvasek.
 */
public class SetContentResponse {

	private MultipartFilePojo content;

	public SetContentResponse() {
	}

	public SetContentResponse(MultipartFilePojo content) {
		this.content = content;
	}

	public MultipartFilePojo getContent() {
		return content;
	}

	public void setContent(MultipartFilePojo content) {
		this.content = content;
	}
}
