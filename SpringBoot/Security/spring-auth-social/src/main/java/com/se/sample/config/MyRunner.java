package com.se.sample.config;


import com.se.sample.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AppProperties appProperties;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Colour: {}", appProperties.getAuth());
        logger.info("Language: {}", appProperties.getOauth2());

        int dd ;
    }
}