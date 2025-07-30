package com.TransactionAssistant.TransactionAssistant.configurations;

import com.TransactionAssistant.TransactionAssistant.batchprocessing.CustomersDataProcessor;
import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SpringBatchConfigurations {

    public SpringBatchConfigurations(){
        System.out.println("Spring Batch configuration file...");
    }

    @Bean
    public ItemProcessor<CustomerData, CustomerData> customerDataCustomerDataItemProcessor() {
        return new CustomersDataProcessor();
    }




    @Bean
    public JpaPagingItemReader<CustomerData> customerDataJpaPagingItemReader(EntityManagerFactory entityManagerFactory){
        JpaPagingItemReader<CustomerData> jpaPagingItemReader
                = new JpaPagingItemReader<>();
        jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
        jpaPagingItemReader.setQueryString("SELECT c from customers c");
        jpaPagingItemReader.setPageSize(100);
        return jpaPagingItemReader;
        //return  new JpaPagingItemReader<>();
    }



    @Bean
    public ItemWriter<CustomerData> customerDataItemWriter(){
        return items->{
            for (CustomerData customerData:items){
                System.out.println("Processed Customer Data "+customerData.getName());
            }
        };
    }


    @Bean
    public Step customerStep(JobRepository jobRepository
    , PlatformTransactionManager platformTransactionManager,
                             JpaPagingItemReader<CustomerData> customerDataJpaPagingItemReader,
                             ItemProcessor<CustomerData,CustomerData> customerDataCustomerDataItemProcessor,
                             ItemWriter<CustomerData>customerDataItemWriter
                             ){
        return new StepBuilder("Customer Step",jobRepository)
                .<CustomerData, CustomerData>chunk(100,platformTransactionManager)
                .reader(customerDataJpaPagingItemReader)
                .writer(customerDataItemWriter)
                .build();
    }
    @Bean
    public Job customerJob(JobRepository jobRepository, Step customerRepository){
        return new JobBuilder("customer job",jobRepository)
                .start(customerRepository)
                .build()
                ;
    }

}
