package com.se.example.springloginformandoauth2tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class PasswordEncoderComponent {
    @Bean
    org.springframework.security.crypto.password.PasswordEncoder passwordEncoder()
    {
        org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
