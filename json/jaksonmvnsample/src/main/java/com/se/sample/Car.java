package com.se.sample;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Evgeniy Skiba on 26.Mar.2019
 */
public class Car {

    private String color;
    private String type;

  //  @JsonProperty("year")
    private int year;// foundationYear;

//    public Car(String color, String type,int year) {
//        this.color = color;
//        this.type = type;
//        this.year = 2000;
//    }


    public Car() {
    }

    public Car(String color, String type, int year) {
        this.color = color;
        this.type = type;
        this.year = year;
    }


    // standard getters setters


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("year33")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", foundationYear=" + year +
                '}';
    }
}
