package com.se.sample.demoflywayenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoFlywayEnvApplication {

    public static void main(String[] args) {

// String dbUrl = System.getenv("JDBC_DATABASE_URL");

        SpringApplication.run(DemoFlywayEnvApplication.class, args);
    }

}
