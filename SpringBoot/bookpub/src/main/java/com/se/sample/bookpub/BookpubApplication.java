package com.se.sample.bookpub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookpubApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "myapp1111111111111");
        SpringApplication.run(BookpubApplication.class, args);
    }

    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }
}
