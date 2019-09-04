package com.se.example.unittestsample.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalService {

  public  UserDto getUser(int userId){
       return new UserDto("test", 12);
   }
}
