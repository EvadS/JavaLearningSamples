package com.se.sample.bookpub;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorldComponent {
    @PostConstruct
    public void sayHello() {
        System.out.println(" - Hello World, from Spring Boot 2!");
    }
}
