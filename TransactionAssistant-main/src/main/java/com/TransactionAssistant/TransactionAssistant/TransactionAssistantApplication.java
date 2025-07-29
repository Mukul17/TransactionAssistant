package com.TransactionAssistant.TransactionAssistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TransactionAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionAssistantApplication.class, args);
	}

}
