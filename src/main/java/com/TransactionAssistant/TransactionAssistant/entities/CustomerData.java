package com.TransactionAssistant.TransactionAssistant.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class CustomerData {

    @Column(name = "Customer ID")
    @Id
    private long Customer_ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Surname")
    private String Surname;
    @Column(name = "Gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender Gender;
    @Column(name = "Birthdate")
    private LocalDate Birthdate;
    @Column(name = "Transaction Amount")
    private BigDecimal Transaction_Amount;
    @Column(name = "Date")
    private LocalDate Date;
    @Column(name = "Merchant Name")
    private String Merchant_Name;
    @Column(name = "Category")
    private String Category;

    public long getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(long customer_ID) {
        Customer_ID = customer_ID;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }



    public LocalDate getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        Birthdate = birthdate;
    }

    public BigDecimal getTransaction_Amount() {
        return Transaction_Amount;
    }

    public void setTransaction_Amount(BigDecimal transaction_Amount) {
        Transaction_Amount = transaction_Amount;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getMerchant_Name() {
        return Merchant_Name;
    }

    public void setMerchant_Name(String merchant_Name) {
        Merchant_Name = merchant_Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
