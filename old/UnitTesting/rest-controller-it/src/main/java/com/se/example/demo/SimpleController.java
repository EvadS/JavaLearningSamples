package com.se.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private SimpleService simpleService;

    @Autowired
    private GreetingService service;

    public SimpleController(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping(value = "/simple",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringJsonObject> simpleResult() {
        return ResponseEntity.ok(simpleService.getText());
    }

    @RequestMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return simpleService.getStr();
    }

}