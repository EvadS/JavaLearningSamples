package com.se.sample.inplementation;

import com.se.sample.interfaces.Operationable;

public class LambdaApp {

    public static void implOperationable_ver1(){
        Operationable op = new Operationable(){

            @Override
            public int calculate(int x, int y) {
                return 0;
            }
        };
    }


    public static void implOperationable_ver2(){
        Operationable operationable;

        operationable = (x,y) -> x+y;

        int result = operationable.calculate(10, 20);
        System.out.println(result); //30

    }
}
