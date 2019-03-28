package com.se.sample;

import com.se.core.MemSizeEstimator;

import java.nio.charset.StandardCharsets;

public class Person {
    private String fname;
    private String lname;

    public Person() {
    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public static final MemSizeEstimator<Person> MemEstimator = tx ->
            MemSizeEstimator.ByteArrayEstimator.estimateSize(tx.fname.getBytes(StandardCharsets.UTF_8)) +
                    MemSizeEstimator.ByteArrayEstimator.estimateSize(tx.lname.getBytes(StandardCharsets.UTF_8)) +
                    + // approximate size of signature
                            16; // Object header + ref


}
