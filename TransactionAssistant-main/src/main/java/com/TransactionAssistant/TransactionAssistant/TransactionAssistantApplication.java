package com.TransactionAssistant.TransactionAssistant;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableBatchProcessing
public class TransactionAssistantApplication {


	public static void main(String[] args) {
		SpringApplication.run(TransactionAssistantApplication.class, args);
	}

}
