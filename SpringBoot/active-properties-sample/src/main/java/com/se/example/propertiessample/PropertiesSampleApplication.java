package com.se.example.propertiessample;

import com.se.example.propertiessample.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertiesSampleApplication implements CommandLineRunner {

    @Autowired
    private WeatherService weatherService;

    public static void main(String[] args) {
        SpringApplication.run(PropertiesSampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(weatherService.forecast());
    }
}
