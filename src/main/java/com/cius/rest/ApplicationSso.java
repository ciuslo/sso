package com.cius.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class ApplicationSso {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationSso.class, args);
		System.out.println("Spring Boot secure rest running.......");
	}

}
