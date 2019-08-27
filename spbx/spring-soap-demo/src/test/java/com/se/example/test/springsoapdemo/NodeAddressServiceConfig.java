package com.se.example.springsoapdemo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NodeAddressServiceConfig {

    @Bean
    public NodeAddressServiceImpl nodeAddressService() {
        return new NodeAddressServiceImpl();
    }
}
