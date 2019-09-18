package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Home {

    @GetMapping("/")
    public  String hello(){
        int a =10;
        return  "hello world";
    }


}
