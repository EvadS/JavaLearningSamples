package com.se.sample.synchronize;


import java.util.Scanner;

/**
 * Производитель-Потребитель"
 */
public class Program_2 {
    public static void main(String[] args) {

        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        new Thread(producer).start();
        new Thread(consumer).start();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Press any key to continue...");

        String userName = myObj.nextLine();  // Read user input
    }
}

// Класс Магазин, хранящий произведенные товары
class Store {
    private int product = 0;

    public synchronized void get() {
        //олжен срабатывать только при наличии хотя бы одного товара.
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    //добавляется товар
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);

        notify();
    }
}

// класс Производитель
class Producer implements Runnable {

    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}

// Класс Потребитель
class Consumer implements Runnable {

    Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
