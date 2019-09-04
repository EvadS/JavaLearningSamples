package com.se.example.unittestsample;

import com.se.example.unittestsample.service.User;
import com.se.example.unittestsample.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitTestSampleApplication  implements ApplicationRunner {

    private User user;

    @Autowired
    private UserRepository repository;


    public static void main(String[] args) {
        SpringApplication.run(UnitTestSampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User();
        user.setName("name " + System.currentTimeMillis());
        user.setAge((int)System.currentTimeMillis());

        repository.save(user);

    }
}
