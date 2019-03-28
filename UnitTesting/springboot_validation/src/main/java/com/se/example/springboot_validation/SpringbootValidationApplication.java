package com.se.example.springboot_validation;

import com.se.example.springboot_validation.entities.User;
import com.se.example.springboot_validation.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootValidationApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootValidationApplication.class, args);
    }

   /* @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (String[] args) -> {
            User user1 = new User("Bob5", "bob@domain.com");
            User user2 = new User("Jenny5", "jenny@domain.com");
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.findAll().forEach(System.out::println);
        };
    }*/
}

