package com.se.rlp.sample;

public class Person {

    public final String fakeName ;

    private String name;

    public Person(String fakeName, String name) {
        this.fakeName = fakeName;
        this.name = name;
    }

    public String getFakeName() {
        return fakeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "fakeName='" + fakeName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
