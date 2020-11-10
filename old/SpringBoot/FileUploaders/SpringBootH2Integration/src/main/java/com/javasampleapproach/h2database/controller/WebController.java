package com.javasampleapproach.h2database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.h2database.model.Customer;
import com.javasampleapproach.h2database.repository.CustomerRepository;

@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;
       
    @RequestMapping("/save")
    public String process(){
        repository.save(new Customer("Jack", "Smith"));
        repository.save(new Customer("Adam", "Johnson"));
        repository.save(new Customer("Kim", "Smith"));
        repository.save(new Customer("David", "Williams"));
        repository.save(new Customer("Peter", "Davis"));
        return "Done";
    }
       
       
    @RequestMapping("/findall")
    public String findAll(){
        String result = "";
           
        for(Customer cust : repository.findAll()){
            result += cust.toString() + "</br>";
        }
           
        return result;
    }
       
    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }
       
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "";
           
        for(Customer cust: repository.findByLastName(lastName)){
            result += cust.toString() + "</br>"; 
        }
           
        return result;
    }
}
