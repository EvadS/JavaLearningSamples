package com.se.sample;


import java.nio.charset.StandardCharsets;


/**
 * Created by Evgeniy Skiba on 26.Mar.2019
 */
public class Address {

    private final  int some_var = 10;

    private byte [] array ;

    public Address(byte[] array) {
        this.array = array;
    }

    public Address() {
    }

    public byte[] getArray() {
        return array;
    }

    public void setArray(byte[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return new String(array, StandardCharsets.UTF_8);
    }
}
