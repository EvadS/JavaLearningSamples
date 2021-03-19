package com.se.sample;

public interface MyInterface {

    void test();

    default void test2(){
        System.out.println("hello from test");
    }

    static void test3(){
        System.out.println("hello from test3");

    }

}
