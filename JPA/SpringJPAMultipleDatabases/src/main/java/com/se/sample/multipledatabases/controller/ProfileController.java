package com.se.sample.multipledatabases.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author javaSolutionsGuide
 *
 */
@RequestMapping("/v1")
@RestController
public class ProfileController {

    @Value("${application.environment}")
    private String applicationEnv;

    @GetMapping
    public String getApplicationEnv() {
        return String.format("%s \n",applicationEnv);
    }
}

