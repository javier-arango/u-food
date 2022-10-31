package com.api.ufood;

import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UFoodApplication {

	// Main Application
	public static void main(String[] args) {
		SpringApplication.run(UFoodApplication.class, args);
	}

}
