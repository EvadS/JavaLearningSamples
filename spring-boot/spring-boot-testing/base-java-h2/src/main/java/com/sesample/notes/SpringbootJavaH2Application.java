package com.sesample.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootJavaH2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaH2Application.class, args);
    }
}

