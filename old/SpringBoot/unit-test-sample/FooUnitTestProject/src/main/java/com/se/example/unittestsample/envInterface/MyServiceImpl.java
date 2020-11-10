package com.se.example.unittestsample.envInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class MyServiceImpl implements  MyService {
    @Autowired
    Environment env;


    @Override
    public void test() {
        // Port
        String rwPort =  env.getProperty("server.port");
        System.out.println("Rw port " + rwPort);
    }

    @Override
    public void setEnvironment(Environment env) {

            int a= 10;
    }
}
