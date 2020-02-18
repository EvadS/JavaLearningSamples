package com.se.sample.counter;

public class Counter {

    private Integer  counter=50;

    public Boolean continueProducing = Boolean.TRUE;

    public synchronized Integer decrement(Integer value){

        counter-=value;
        System.out.println(String.format("Счетчик уменьшен на  : %s", value));
        System.out.println(String.format("Значение счетчика    : %s ", counter));
        System.out.println("================================================");

        return counter;

    }

    public synchronized Integer increment(Integer value){
        counter-=value;
        System.out.println(String.format("Счетчик увеличен на : %s ", value));
        System.out.println(String.format("Значение счетчика   : %s ", counter));
        System.out.println("================================================");
        //TODO: зачем ??
        return counter;


    }
}
