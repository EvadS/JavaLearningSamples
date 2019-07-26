package com.se.spring.cample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.UnknownHostException;
import java.util.Collections;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        ApplicationContext applicationContext =  app.run(args);


        //Listing all the Spring Beans that are loaded
//        for (String name : applicationContext.getBeanDefinitionNames()) {
//            System.out.println("------------" + name);
//        }
    }
}