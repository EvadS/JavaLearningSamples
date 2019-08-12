package com.transaction.sample;

public class MyClass {

    int maxSize ;

    public MyClass(int maxSize) {
        if (maxSize < 1) {
            throw new IllegalArgumentException("LRUMap max size must be greater than 0");
        }
        this.maxSize = maxSize;
    }
}
