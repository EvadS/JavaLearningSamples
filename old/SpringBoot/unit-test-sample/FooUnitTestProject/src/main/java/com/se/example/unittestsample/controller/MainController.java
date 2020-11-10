package com.se.example.unittestsample.controller;


import com.se.example.unittestsample.dao.User;
import com.se.example.unittestsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<User> all = userService.findAll();

        StringBuilder sb = new StringBuilder();

        all.forEach(p -> sb.append(p.getId()).append(" | ").append(p.getName() ).append(" | ").append(p.getAge()) );

        return sb.toString();
    }

}