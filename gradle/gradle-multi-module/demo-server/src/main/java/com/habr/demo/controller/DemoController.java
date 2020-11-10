package com.habr.demo.controller;


import com.example.common.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final MyService myService;

    public DemoController(MyService myService) {
        this.myService = myService;
    }

   @GetMapping("/")
    public String home() {
        return myService.message();
    }
}
