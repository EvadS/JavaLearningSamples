package com.se.sample.enums;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.RedDel;

        // вывести значение перечислимо г о типа
        System.out.println(" Знaчeниe ар : " + ap);
        System.out.println();
        ap = Apple.GoldenDel;

        // сравнить два значения перечислимо г о типа
        if (ap == Apple.GoldenDel)
            System.out.println("Пepeмeннaя ар содержит GoldenDel . \n ");

        // применить перечисление для управления оператором switch
        switch (ap) {
            case Jonathan:
                System.out.println(" Copт Jonathan красный . ");
                break;
            case GoldenDel:
                System.out.println(" Copт Golden Delicious желтый . ");
                break;
            case RedDel:
                System.out.println(" Copт RedDelicious красный . ");
                break;
            case Winesap:
                System.out.println(" Copт Winesap кр асный . ");
                break;
            case Cortland:
                System.out.println("Copт Cortland красный . ");
                break;
        }

        //------------------------------------------------
        Apple apple = Apple.valueOf("Winesap");
        Apple[] apllesArray = Apple.values();

        for (Apple а : apllesArray) {
            System.out.println(а);
        }
        System.out.println();
    }
}
