package com.ingestion;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

@SpringBootApplication
@Configuration
public class SpringBootFileUploadHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileUploadHelloWorldApplication.class, args);
	}

	@Bean
	public SimpleUrlHandlerMapping getMappings() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();

		Properties urlProperties = new Properties();
		urlProperties.put("/index", "myController");

		mapping.setMappings(urlProperties);

		return mapping;
	}
	
	@Bean("myController")
	public Mycontroller getmyContoller() {
		return new Mycontroller();
	}
	
}

class Mycontroller{
	
}

