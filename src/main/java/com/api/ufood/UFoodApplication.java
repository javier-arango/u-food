package com.api.ufood;

import com.api.ufood.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class UFoodApplication {

	// Main Application
	public static void main(String[] args) {
		SpringApplication.run(UFoodApplication.class, args);
	}

}
