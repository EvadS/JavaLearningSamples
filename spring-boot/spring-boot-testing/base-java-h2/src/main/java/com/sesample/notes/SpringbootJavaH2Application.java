package com.sesample.notes;

import com.sesample.notes.config.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(JpaConfiguration.class)
public class SpringbootJavaH2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootJavaH2Application.class, args);
    }
}

