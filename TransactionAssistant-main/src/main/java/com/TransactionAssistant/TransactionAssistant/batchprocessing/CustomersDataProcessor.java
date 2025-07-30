package com.TransactionAssistant.TransactionAssistant.batchprocessing;


import com.TransactionAssistant.TransactionAssistant.entities.CustomerData;
import jakarta.annotation.PreDestroy;
import org.springframework.batch.item.ItemProcessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class CustomersDataProcessor implements ItemProcessor<CustomerData,CustomerData> {

    private BufferedWriter bufferedWriter;



    public CustomersDataProcessor(){
        //this.bufferedWriter=bufferedWriter;
        System.out.println("CustomersDataProcessor file.....");
    }


    @Override
    public CustomerData process(CustomerData item) throws Exception {


        File file
                =new File("filtered-customers.txt");


        if (!file.exists()) {
            file.createNewFile();
        }
        this.bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        bufferedWriter.write("Start Time is "+ LocalDateTime.now());
       /* System.out.println("processing... " + item.getName()
        +"-> "
        +item.getTransaction_Amount()
        );
*/
        if ((item.getTransaction_Amount().intValue()<100))
       {
           bufferedWriter.write("Filtered: "+item.getCustomer_ID() +
                   "Amount: "
                   +item.getTransaction_Amount()
                +"Merchant Name :"+item.getMerchant_Name()
           );
           item.setMerchant_Name("NOT_AUTHORIZED");
           bufferedWriter.newLine();
           bufferedWriter.flush();
           return null;
       }

        System.out.println(item.getMerchant_Name());
       bufferedWriter.write("End Time is "+ LocalDateTime.now());

        return item;
    }


    @PreDestroy
    public void closeWriter() throws Exception{
        bufferedWriter.close();
    }
}
