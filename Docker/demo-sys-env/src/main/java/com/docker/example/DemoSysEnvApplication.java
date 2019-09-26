package com.docker.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoSysEnvApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DemoSysEnvApplication.class, args);
    }
    private static final Logger logger = LoggerFactory.getLogger(DemoSysEnvApplication.class);



}
