package com.se.sample;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        int choice = 0;

        do {
            printMenu();
            choice = getChoice();

            switch (choice){
                case  1: {
                    ThreadHelper.test();
                    break;
                }

                case  2:{
                    ThreadHelper.testWithDelay();
                    break;
                }

                case  3:{
                    ThreadHelper.testExecutor();
                    break;
                }
            }

        } while (choice != 0);

        System.out.println("Before exit!");
    }

    public static void printMenu() {
        System.out.println("0. Exit.");
        System.out.println("1. Runnable sample.");
        System.out.println("1. Runnable sample with delay.");
        System.out.println("2. Executor Service.");
    }

    public static int getChoice() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choise :");

        return in.nextInt();
    }
}
