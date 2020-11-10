package com.se.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService{
    @Override
    public StringJsonObject getText(){
        return new StringJsonObject("Cool!");
    }

    @Override
    public String getStr() {
        return "Hello Mock";
    }
}