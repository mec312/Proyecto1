package com.project.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableCaching
@SpringBootApplication
@EnableMongoRepositories
@ComponentScan(basePackages = {"com.project"})
public class ApiBsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBsClientApplication.class, args);
	}

}
