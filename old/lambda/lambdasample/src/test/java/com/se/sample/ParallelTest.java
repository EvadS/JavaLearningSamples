package com.se.sample;

import org.junit.Test;

import java.util.Arrays;

public class ParallelTest {



    public static double[] imperativeInitilize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++)
            values[i] = i;
        return values;
    }

    public static double[] parallelinitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }


    @Test
    public void test2(){

    }
}
