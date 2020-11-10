package com.se.comparator.sample;

import java.math.BigInteger;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Message> messages = new ArrayList();
        messages.add(new Message("Hello, World!"));
        messages.add(new Message("Hello, Sun!"));
        System.out.println(messages);


        List<CryptoCurrencyAmount> amountList = new ArrayList();
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(234)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(43)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(43)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(789)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(96)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(137)));
        amountList.add(new CryptoCurrencyAmount(BigInteger.valueOf(198)));
        {
            System.out.println("before sor");
            for (CryptoCurrencyAmount amount : amountList) {
                System.out.println("amount : " + amount);
            }
        }

        Collections.sort(amountList);

        System.out.println("before sor");
        for (CryptoCurrencyAmount amount : amountList) {
            System.out.println("amount : " + amount);

        }

        System.out.println("========================================");
        //--------------------------------------------------
        //При добавлении новых элементов объект TreeSet автоматически проводит сортировку,
        // помещая новый объект на правильное для него место.
        TreeSet<Comp> ex = new TreeSet<Comp>();
        ex.add(new Comp("Stive Global", 121));
        ex.add(new Comp("Stive Global", 221));
        ex.add(new Comp("Nancy Summer", 3213));
        ex.add(new Comp("Aaron Eagle", 3123));
        ex.add(new Comp("Barbara Smith", 88786));

        for (Comp e : ex) {
            System.out.println("Str: " + e.str + ", number: " + e.number);
        }


        //--------------------------------------------------

        Product[] p = new Product[3];

        // заполним объект Product содержимым
        p[0] = new Product();
        p[0].setName("Milk");
        p[0].setPrice(7.56);
        p[0].setQuantity(56);

        p[1] = new Product();
        p[1].setName("Coffee");
        p[1].setPrice(17.00);
        p[1].setQuantity(32);

        p[2] = new Product();
        p[2].setName("Tea");
        p[2].setPrice(12.50);
        p[2].setQuantity(0);

        // выведем данные без сортировки
        System.out.println("============ no sorted ==============");

        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        // отсортируем и выведем данные по цене
        System.out.println("========== sorted by price===========");

        Arrays.sort(p, new SortedByPrice());

        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }

        // отсортируем и выведем данные по названию
        System.out.println("========== sorted by name ===========");

        Arrays.sort(p, new SortedByName());
        for (Product i : p) {
            System.out.println("Name: " + i.getName() +
                    " price: " + i.getPrice() +
                    " quantity: " + i.getQuantity());
        }
        System.out.println("---------------------\nHello World!");
    }
}
