package com.se.sample.codingBat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functuional1 {
    public  static void  main(String [] args){

        Integer [] arr = new Integer[]{1,2,3};
        List<Integer> in  = (List<Integer>) Arrays.asList(arr);

        List<Integer> res = doubling(in);

        res.stream().forEach(x-> System.out.print(x));
    }

    public static List<Integer> doubling(List<Integer> nums) {
        return nums.stream().map( x -> x * 2).collect(Collectors.toList());
    }

}
