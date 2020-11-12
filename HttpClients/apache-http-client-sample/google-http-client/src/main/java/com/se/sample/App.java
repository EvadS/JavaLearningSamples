package com.se.sample;

import org.joda.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.print("***\n Hello World! " + getLocalCurrentDate() + "\n***\n");
    }

    private static String getLocalCurrentDate() {
        LocalDate date = new LocalDate();
        return date.toString();
    }
}
