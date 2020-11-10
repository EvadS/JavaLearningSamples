package com.se.example.springbootjavah2;

import com.se.example.springbootjavah2.entities.Customer;
import com.se.example.springbootjavah2.entities.CustomerId;
import com.se.example.springbootjavah2.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJavaH2Application implements CommandLineRunner {

    @Autowired
    CustomerServices customerService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        save();
        save();

        showAll();
    }

    private void save() {
        CustomerId jackId = new CustomerId(1000, "azc");
        Customer jack = new Customer(jackId, "A & Z", "Jack");

        customerService.save(jack);

        CustomerId jackId2 = new CustomerId(1001, "azcbn");
        Customer jack2 = new Customer(jackId2, "A & Z", "Jack2");

        customerService.save(jack2);
    }

    public void showAll() {
        System.out.println("===============Show All Customers' Info===============");
        customerService.showAll();
    }
}

