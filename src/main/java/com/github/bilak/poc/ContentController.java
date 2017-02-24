package com.github.bilak.poc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author lvasek.
 */
@RestController
public class ContentController {

	@PostMapping("/content")
	public ResponseEntity<SetContentResponse> setContent(@RequestPart("content") MultipartFile content) throws IOException {

		return ResponseEntity.ok(
				new SetContentResponse(
						new MultipartFilePojo(
								content.getName(), content.getOriginalFilename(), content.getContentType(), content.getBytes()
						)
				)
		);
	}

	@PostMapping("/content-and-metadata")
	public ResponseEntity<SetContentAndMetaDataResponse> setContentAndMetaData(@RequestPart("content") MultipartFile content,
			@RequestPart("meta-data") ContentMetaData contentMetaData) throws IOException {
		return ResponseEntity.ok(
				new SetContentAndMetaDataResponse(
						new MultipartFilePojo(content.getName(), content.getOriginalFilename(), content.getContentType(), content.getBytes()),
						contentMetaData
				)
		);
	}

}
