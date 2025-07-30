package com.TransactionAssistant.TransactionAssistant.services;

import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import com.TransactionAssistant.TransactionAssistant.repositories.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private BufferedWriter bufferedWriter;

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


    public void getAllCustomersDataAndTime() throws IOException {
       // Pageable pageable = PageRequest.of(pageNo,pageSize);
        List<CustomerData> page = customerRepository.findAll();

            File file
                    =new File("filtered-customers-withoutjob.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            this.bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("The size of file is "+page.size());
            System.out.println("Curent Time is "+System.currentTimeMillis());
            for (CustomerData customerData :page){

                if ((customerData.getTransaction_Amount().intValue()<100))
                {
                    bufferedWriter.write("Filtered: "+customerData.getCustomer_ID() +
                            "Amount: "
                            +customerData.getTransaction_Amount()
                            +"Merchant Name :"+customerData.getMerchant_Name()
                    );
                    customerData.setMerchant_Name("NOT_AUTHORIZED");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }

            }
        System.out.println("End Time is "+System.currentTimeMillis());

    }


    public Optional<CustomerData> getCustomerByCustomerId(long customer_Id){
        return customerRepository.findById(customer_Id);
    }

}
