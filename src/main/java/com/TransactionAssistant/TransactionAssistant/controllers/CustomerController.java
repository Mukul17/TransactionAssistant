package com.TransactionAssistant.TransactionAssistant.controllers;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import com.TransactionAssistant.TransactionAssistant.repositories.CustomerRepository;
import com.TransactionAssistant.TransactionAssistant.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/customersdata")
    public List<CustomerData> customerDataResponseEntity(){
        return customerService.getAllCustomersData();
    }

    @GetMapping("/{custId}")
    public CustomerData customerDataById(@PathVariable  Long custId){
        return customerService.getCustomerByCustomerId(custId).get();
    }


}
