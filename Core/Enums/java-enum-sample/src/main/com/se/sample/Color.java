package com.se.sample;

/**
 * Created by Evgeniy Skiba on 22.Mar.2019
 */
public enum Color implements  BaseEnumActions {
    RED(1), YELLOW(2), BLUE(3); //each is an instance of Color

    private int value;

    private Color(){}

    private Color(int i){
        this.value = i;
    }

    //define instance method
    public void printValue(){
        System.out.println(this.value);
    }

    @Override
    public void action1() {

    }

    @Override
    public void action2() {

    }

    @Override
    public void action3() {

    }
}
