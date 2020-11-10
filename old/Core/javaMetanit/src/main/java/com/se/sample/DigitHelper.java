package com.se.sample;

import java.util.Scanner;

public class DigitHelper {
    public static void test1() {
        int num111 = 0x6F; // 16-тиричная система, число 111
        int num8 = 010; // 8-ричная система, число 8
        int num13 = 0b1101; // 2-ичная система, число 13

        int x = 5;
        int y = 6;
        System.out.printf("x=%d; y=%d \n", x, y);

        String name = "Tom";
        int age = 30;
        float height = 1.7f;

        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name, age, height);

        //---------------------------------------------------------------------
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        System.out.printf("Your number: %d \n", num);
        in.close();

        //------------------------------------------------------
        Scanner in2 = new Scanner(System.in);
        System.out.print("Input name: ");
        String name2 = in2.nextLine();
        System.out.print("Input age: ");
        int age2 = in2.nextInt();
        System.out.print("Input height: ");
        float height2 = in2.nextFloat();
        System.out.printf("Name: %s  Age: %d  Height: %.2f \n", name2, age2, height2 );
        in2.close();
    }

    static void sum(int ...nums){

        int result =0;
        for(int n: nums)
            result += n;
        System.out.println(result);
    }
}

