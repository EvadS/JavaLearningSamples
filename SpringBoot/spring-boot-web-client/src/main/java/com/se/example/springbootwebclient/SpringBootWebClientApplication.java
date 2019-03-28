package com.se.example.springbootwebclient;

import com.se.example.springbootwebclient.controller.WebClientconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        WebClientconfig.class
})
public class SpringBootWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebClientApplication.class, args);
    }

}

