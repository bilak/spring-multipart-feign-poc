package com.github.bilak.poc;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lvasek.
 */
@FeignClient(name = "contentClient", url = "http://localhost:8080", configuration = ContentClient.Config.class)
public interface ContentClient {

	@RequestMapping(value = "/content", method = { RequestMethod.POST })
	ResponseEntity<SetContentResponse> setContent(@RequestPart("content") MultipartFile content);

	@RequestMapping(value = "/content-and-metadata", method = { RequestMethod.POST })
	ResponseEntity<SetContentAndMetaDataResponse> setContentAndMetaData(@RequestPart("content") MultipartFile content,
			@RequestPart("meta-data") ContentMetaData contentMetaData);

	@Configuration
	class Config {
		@Bean
		@Primary
		@Scope("prototype")
		public Encoder multipartFormEncoder() {
			return new SpringFormEncoder();
		}

		@Bean
		public feign.Logger.Level multipartLoggerLevel() {
			return feign.Logger.Level.FULL;
		}
	}
}
