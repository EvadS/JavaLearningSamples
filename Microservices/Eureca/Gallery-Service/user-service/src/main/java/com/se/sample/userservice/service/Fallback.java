package com.se.sample.userservice.service;


import com.se.sample.userservice.model.Bucket;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Fallback implements ServiceFeignClient {

    @Override
    public List<Bucket> getAllEmployeesList() {
        return new ArrayList<Bucket>();
    }

}