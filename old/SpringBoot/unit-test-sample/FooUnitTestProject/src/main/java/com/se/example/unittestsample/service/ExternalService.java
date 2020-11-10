package com.se.example.unittestsample.service;

import com.se.example.unittestsample.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

  public UserDto getUser(int userId){
       return new UserDto("test", 12);
   }
}
