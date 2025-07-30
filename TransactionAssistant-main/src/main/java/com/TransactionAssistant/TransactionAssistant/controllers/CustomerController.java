package com.TransactionAssistant.TransactionAssistant.controllers;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import com.TransactionAssistant.TransactionAssistant.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/data")
    public List<CustomerData> getCustomersDataviaPage(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10")  int pageSize ){
        return customerService.getAllCustomersDataViaPageable(pageNo,pageSize);
    }

    @GetMapping("/{custId}")
    public CustomerData customerDataById(@PathVariable  Long custId){
        return customerService.getCustomerByCustomerId(custId).get();
    }



    @GetMapping("/da")
    public void customerDataById() throws IOException {
         customerService.getAllCustomersDataAndTime();
    }

}
