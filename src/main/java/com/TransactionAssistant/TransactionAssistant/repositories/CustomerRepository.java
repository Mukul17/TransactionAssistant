package com.TransactionAssistant.TransactionAssistant.repositories;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerData,Long> {

     //List<CustomerData> getAllCustomersData();

}
