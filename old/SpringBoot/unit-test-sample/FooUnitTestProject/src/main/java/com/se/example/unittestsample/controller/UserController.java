package com.se.example.unittestsample.controller;

import com.se.example.unittestsample.dao.User;
import com.se.example.unittestsample.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
//    public User get(@PathVariable Long id) throws NotFoundException {
//
//        Optional<User> myUser = userRepository.findOne(id);
//        if(myUser.isPresent()){
//            return myUser.get();
//        }else {
//           throw  new NotFoundException("can 't found");
//        }
//
//    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);

    }

    // for demo test
    @RequestMapping(value = "user_test/{id}", method = RequestMethod.GET)
    public User get_test(@PathVariable Long id) {
        User user = new User();
        user.setAge(20);
        user.setName("name " + Instant.now());
        user.setId(1L);
        return user;
    }
}