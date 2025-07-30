package com.TransactionAssistant.TransactionAssistant.batchprocessing;


import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import org.springframework.batch.item.ItemProcessor;

public class CustomersDataProcessor implements ItemProcessor<CustomerData,CustomerData> {

    public CustomersDataProcessor(){
        System.out.println("CustomersDataProcessor file.....");
    }


    @Override
    public CustomerData process(CustomerData item) throws Exception {
        System.out.println("processing... "+item.getName());

        if ((item.getTransaction_Amount().intValue()<100))
       {
           return null;
       }
       item.setMerchant_Name("NOT_AUTHORIZED");
        System.out.println(item.getMerchant_Name());
       return item;
    }


}
