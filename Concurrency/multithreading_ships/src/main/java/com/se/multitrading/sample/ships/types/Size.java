package com.se.multitrading.sample.ships.types;

public enum Size {
    SMALL(10), MIDDLE(50), LARGE(100);

    Size(int value){
        this.value = value;
    }
    private int value;

    public int getValue() {
        return value;
    }
}
