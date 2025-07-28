package com.TransactionAssistant.TransactionAssistant.services;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import com.TransactionAssistant.TransactionAssistant.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    public List<CustomerData> getAllCustomersData(){
      return customerRepository.findAll();
    }

    public Optional<CustomerData> getCustomerByCustomerId(long customer_Id){
        return customerRepository.findById(customer_Id);
    }

}
