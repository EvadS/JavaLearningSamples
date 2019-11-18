package com.se.sample.gsconsumingrest.controller;

import com.se.sample.gsconsumingrest.model.User;
import com.se.sample.gsconsumingrest.model.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final Logger _log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate template;
    @ResponseBody
    @RequestMapping("/test")
    public Map<String, Object> test(){
        Map<String, Object> map = new LinkedHashMap<>();
        String content = template.getForObject("http://localhost:18080/", String.class);
        map.put("result", content);
        return map;
    }

    @GetMapping("/test2")
    public User test2(){
        return new User(1,"222222");
    }


    @ResponseBody
    @RequestMapping("/test/user")
    public Map<String, Object> testGetUser(){
        Map<String, Object> map = new LinkedHashMap<>();
        User user = template.getForObject("http://localhost:8080/user/100", User.class);
        map.put("result", user);
        return map;
    }

    @PostMapping(value = "/create")
    public  String createUser(@RequestBody @Valid User user){
        UserResponse userResponse = new UserResponse(user, true);
        return "";
    }
}
