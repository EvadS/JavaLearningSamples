package com.docker.sample.controller;

import com.docker.sample.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer GetCustomer(@PathVariable Long id) {
        return new Customer(id, "Customer" + id);
    }
}