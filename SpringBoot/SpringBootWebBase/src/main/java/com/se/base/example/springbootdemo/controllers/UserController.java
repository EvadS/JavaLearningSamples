package com.se.base.example.springbootdemo.controllers;

import com.se.base.example.springbootdemo.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/api/user")
public class UserController {
    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }

    @PostMapping("/create")
    public String testCreate (UserModel user ) {

        System.out.println(String.format("Name : %s , Pass : %s",user.getUsername(), user.getPassword()));
        return "Hello world";
    }

    @PostMapping("/create-error")
    public String testCreateExc (UserModel user ) {
        System.out.println(String.format("Name : %s , Pass : %s",user.getUsername(), user.getPassword()));

        throw  new RuntimeException("Not implement !!!");
    }

    @GetMapping("/get-user")
    public UserModel getUsertest()
    {
    UserModel user = new UserModel();
    user.setPassword("pass");
    user.setUsername("user name");
    return  user;
    }

    @GetMapping("/get-users")
    public List<UserModel> getUserstest()
    {
        List<UserModel> list = new ArrayList<>();

        UserModel user = new UserModel();
        user.setPassword("pass");
        user.setUsername("user name");
        list.add(user);

        user = new UserModel();
        user.setPassword("pass");
        user.setUsername("user name");
        list.add(user);

        return  list;
    }

}
