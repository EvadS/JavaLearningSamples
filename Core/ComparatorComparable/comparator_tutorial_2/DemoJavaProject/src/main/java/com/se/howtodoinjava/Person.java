package com.se.howtodoinjava;

class Person{

    private String name;
    private int age;
    public Person(String n, int a){

        name=n;
        age=a;
    }
    String getName(){return name;}
    int getAge(){return age;}
}