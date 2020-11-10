package com.se.app;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.se.app.config.SpringConfig;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
   
        System.out.println("Hello World! " );
    }
}