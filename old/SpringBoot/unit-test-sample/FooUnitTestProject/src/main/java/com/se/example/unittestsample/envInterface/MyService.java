package com.se.example.unittestsample.envInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public interface MyService {


    void test();
    void setEnvironment(Environment env);
}
