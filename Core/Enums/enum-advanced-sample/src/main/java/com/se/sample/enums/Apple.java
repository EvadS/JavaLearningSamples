package com.se.sample.enums;

public enum Apple {
    //константы перечислиимого типа
    Jonathan(10) , GoldenDel(9) , RedDel(15) , Winesap(9) , Cortland(20);

    private int price;

    Apple() {
        price = -1;
    }

    Apple(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Яблoкo сорта " + this.name() + " стоит " + price+ " центов.";
    }
}
