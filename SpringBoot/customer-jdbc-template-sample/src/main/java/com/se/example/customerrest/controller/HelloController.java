package com.se.example.customerrest.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
// https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#api
@Api(description = "saying hello", tags = "hello")
@RequestMapping("/api")
public class HelloController {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/index",
            produces = "application/json")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
