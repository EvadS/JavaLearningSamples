package com.se.sample.models;

public class Guid {
    private  String dumyFields;

    public Guid() {
    }

    public Guid(String dumyFields) {

        this.dumyFields = dumyFields;
    }

    public String getDumyFields() {
        return dumyFields;
    }

    public void setDumyFields(String dumyFields) {
        this.dumyFields = dumyFields;
    }

    @Override
    public String toString() {
        return "Guid{" +
                "dumyFields='" + dumyFields + '\'' +
                '}';
    }
}
