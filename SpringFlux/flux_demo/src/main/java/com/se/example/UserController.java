package com.se.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Mono<User> post(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public Flux<User> get() {
        return userService.get();
    }

    @GetMapping("{lastName}")
    public Flux<User> getByLastName(@PathVariable(name = "lastName") String lastName) {
        return userService.getByLastName(lastName);
    }
}