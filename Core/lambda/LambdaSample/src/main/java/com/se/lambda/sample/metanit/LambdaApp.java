package com.se.lambda.sample.metanit;

import java.util.Scanner;

public class LambdaApp {
    public static void main(String[] args) {

        Operationable operation;
        // левая часть содержит список параметров выражения
        // правая собственно представляет тело лямбда-выражения, где выполняются все действия.
        operation = (x, y) -> x + y;

        int result = operation.calculate(10, 20);
        System.out.println(result); //30

        System.out.print("Multiply : ");
        operation = (x, y) -> x * y;

        result = operation.calculate(10, 20);
        System.out.println(result); //30

        // посредством анонимного класса
        Operationable2 op = new Operationable2() {
            @Override
            public int calculate(int x, int y) {
                return x * y ;
            }
        };


        int z = op.calculate(20, 10);
        System.out.println(z); // 30


        float a = 10f;
        float b = 5f;
        Operationable3 op3 = ()-> 10f * 5f;

        float x= op3.calculate();
        System.out.println("x : " + x); // 30

        Operationable4 op4 =(x2)-> Math.pow(x2,2);

        double res = op4.calculate(10);
        System.out.println("x : " + x); // 30


        // блоки кода
        Operationable op1 = (int x1, int y1)-> {

            if(y1==0)
                return 0;
            else
                return x1/y1;
        };

        System.out.println(op1.calculate(20, 10)); //2
        System.out.println(op1.calculate(20, 0)); //0

        //Обобщенный функциональный интерфейс
        GeneralizeOperationable<Integer> gen1 = (x3, y3)-> x3 + y3;
        GeneralizeOperationable<String> gen2 = (x3, y3) -> x3 + y3;

        System.out.println(gen1.calculate(20, 10)); //30
        System.out.println(gen2.calculate("20", "10")); //2010

        Scanner in = new Scanner(System.in);
        System.out.print("Press any key to continue...");
        String line = in.next();
    }
}
