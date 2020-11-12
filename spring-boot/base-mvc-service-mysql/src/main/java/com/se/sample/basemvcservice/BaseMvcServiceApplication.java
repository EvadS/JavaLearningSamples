package com.se.sample.basemvcservice;

import com.se.sample.basemvcservice.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaseMvcServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseMvcServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
