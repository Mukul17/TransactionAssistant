package com.TransactionAssistant.TransactionAssistant.services;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import com.TransactionAssistant.TransactionAssistant.repositories.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        int pageNo=0;
        int pageSize=10;
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<CustomerData> page = customerRepository.findAll(pageable);
        return page.getContent();
    }
    public List<CustomerData> getAllCustomersDataViaPageable(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<CustomerData> page = customerRepository.findAll(pageable);
        System.out.println("Total Pages  count :"+page.getTotalPages());
        System.out.println("Total Elements  count :"+page.getTotalElements());
        return page.getContent();
    }



    public Optional<CustomerData> getCustomerByCustomerId(long customer_Id){
        return customerRepository.findById(customer_Id);
    }

}
