package com.se.example.springbootjavah2.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @EmbeddedId
    private CustomerId customerId;


    private String company;
    private String name;

    public Customer() {

    }

    public Customer(CustomerId customerId, String company, String name) {
        this.customerId = customerId;
        this.company = company;
        this.name = name;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public CustomerId getCustomerId() {
        return this.customerId;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}