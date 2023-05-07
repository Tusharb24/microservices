package com.example.organizartionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrganizartionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizartionServiceApplication.class, args);
	}

}
