package com.se.sample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// <1>
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // <2>
        SpringApplication.run(DemoApplication.class, args);
    }
}
