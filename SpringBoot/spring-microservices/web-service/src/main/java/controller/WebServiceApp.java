package controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import boot.EmailServiceApp;
import boot.UserServiceApp;

@SpringBootApplication
@ComponentScan(basePackages = { "controller", "service" })
public class WebServiceApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserServiceApp.class, EmailServiceApp.class).run(args);
    }

}
