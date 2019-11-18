package com.docker.sample.controller;

import com.docker.sample.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private org.springframework.core.env.Environment environment;

    public CustomerController(){
    }

    @Value("${application.message}")
    String message;


    @GetMapping("/{id}")
    public Customer GetCustomer(@PathVariable Long id) {
        return new Customer(id, "Customer" + id);
    }


    @GetMapping("/message")
    public String getMessage() {
        System.out.println("---------active profile : "+ environment.getActiveProfiles()[0] );

        return message;
    }

    @GetMapping("/checkProfile")
    public String[] checkProfile() {
        String[] activeProfiles = environment.getActiveProfiles();      // it will return String Array of all active profile.
        for(String profile:activeProfiles) {
            System.out.print(profile);
        }
        return activeProfiles;
    }

}