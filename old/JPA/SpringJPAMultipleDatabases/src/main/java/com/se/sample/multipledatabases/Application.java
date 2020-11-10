package com.se.sample.multipledatabases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    @Autowired
    private Environment env;

    @PostConstruct
    public void initApplication() throws IOException {
        LOGGER.info("--**-- Running with Spring profile(s) : {}", env.getActiveProfiles());
    }
}