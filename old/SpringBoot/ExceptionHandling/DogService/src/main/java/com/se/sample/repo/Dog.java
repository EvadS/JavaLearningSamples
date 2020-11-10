package com.se.sample.repo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "foo")
public class Dog {
    private long id;
    private String name;
    private int age;
}