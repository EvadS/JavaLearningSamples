package com.se.samplelogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleLoggingApplication {

   static Logger logger = LoggerFactory.getLogger(SampleLoggingApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SampleLoggingApplication.class, args);
        logger.info("application started");

        System.out.println("folder to storage logs:");
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
