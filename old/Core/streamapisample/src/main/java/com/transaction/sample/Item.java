package com.transaction.sample;

class Item {
    private int value;

    public Item(int value) {
        this.value = value;
    }

    // constructors

    public boolean isQualified() {
        return value % 2 == 0;
    }

    public void operate() {
        System.out.println("Even Number");
    }
}