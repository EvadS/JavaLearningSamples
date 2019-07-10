package com.se.sample;

/**
 * Created by Evgeniy Skiba on 22.Mar.2019
 */
public enum Currency {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    private Currency(int value) {
        this.value = value;
    }
};


