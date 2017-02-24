package com.github.bilak.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "feign.hystrix.enabled=false", "server.port=8080" },
		classes = { SpringMultipartFeignPocApplication.class },
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringMultipartFeignPocApplicationTests {

	@Autowired
	private ContentClient contentClient;

	@Test
	public void testSendContentWithRequestPart() throws IOException {

		MultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "abcd".getBytes());
		ResponseEntity<SetContentResponse> response = this.contentClient.setContent(multipartFile);
		MultipartFilePojo mp = response.getBody().getContent();
		// this is changed on controller
		// assertEquals("name does not match", mp.getName(), multipartFile.getName());
		assertEquals("original name does not match", mp.getOriginalFilename(), multipartFile.getOriginalFilename());
		assertEquals("content type does not match", mp.getContentType(), multipartFile.getContentType());
		assertEquals("content does not match", new String(mp.getContent(), "UTF-8"), new String(multipartFile.getBytes(), "UTF-8"));
	}

	@Test
	public void testSendContentAndMetaDataWithRequestPart() throws IOException {
		MultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "abcd".getBytes());
		ContentMetaData contentMetaData = new ContentMetaData("id12345", "me");
		ResponseEntity<SetContentAndMetaDataResponse> responseResponseEntity = this.contentClient.setContentAndMetaData(multipartFile, contentMetaData);

		MultipartFilePojo mp = responseResponseEntity.getBody().getContent();
		ContentMetaData md = responseResponseEntity.getBody().getContentMetaData();

		assertEquals("original name does not match", mp.getOriginalFilename(), multipartFile.getOriginalFilename());
		assertEquals("content type does not match", mp.getContentType(), multipartFile.getContentType());
		assertEquals("content does not match", new String(mp.getContent(), "UTF-8"), new String(multipartFile.getBytes(), "UTF-8"));

		assertEquals("content id does not match", md.getContentId(), contentMetaData.getContentId());
		assertEquals("creator does not match", md.getCreator(), contentMetaData.getCreator());
	}

}
