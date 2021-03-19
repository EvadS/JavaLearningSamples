package com.se.sample;

public class MeasureCount {
    static int total;
    int number;

    public MeasureCount() {
        number = 0;
    }

    static int getTotal() {
        return total;
    }

    void increment() {
        number++;
        total++;
    }

    int getNumber() {
        return number;
    }
}
