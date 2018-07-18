package com.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.integration")
@EnableDiscoveryClient
public class IngestionBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngestionBackendApplication.class, args);
	}
}
