package com.se.example.unittestsample.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {

    @Autowired
    private SomeDependency someDependency;

    @Value("${someProperty}")
    private String someProperty;

    public SomeClass(){
        int bn =10;
    }

}
