package com.github.bilak.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMultipartFeignPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultipartFeignPocApplication.class, args);
	}
}