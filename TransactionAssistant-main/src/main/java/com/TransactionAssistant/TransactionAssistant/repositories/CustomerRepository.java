package com.TransactionAssistant.TransactionAssistant.repositories;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerData,Long> {

     //List<CustomerData> getAllCustomersData();

}
