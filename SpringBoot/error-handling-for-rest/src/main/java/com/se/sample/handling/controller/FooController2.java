package com.se.sample.handling.controller;

import com.se.sample.handling.exception.CustomException1;
import com.se.sample.handling.exception.CustomException2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v2")
public class FooController2 {


    @GetMapping("/ex2")
    @ExceptionHandler(value = {CustomException1.class, CustomException2.class})
    public void handleException() {
        //
        throw  new CustomException2();
    }
}