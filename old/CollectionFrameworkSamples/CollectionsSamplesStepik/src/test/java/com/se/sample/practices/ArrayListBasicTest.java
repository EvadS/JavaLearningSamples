package com.se.sample.practices;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ArrayListBasicTest {

    private final List<Integer> input = Arrays.asList(847, 271, 663, 473, 376, 133, 693, 13, 382, 879);
    private final int actualElement = 879;


     private List<String> inputStringList = Arrays.asList("hi", "hello", "goodmorning" ,"ass");
    private List<String> actualStringList = Arrays.asList("goodmorning", "goodmorning", "goodmorning" ,"goodmorning");
    @Test
    public void maxElem() {
        int maxElement = ArrayListBasic.maxElem(input);
        Assert.assertEquals(maxElement, actualElement);
    }

    @Test
    public void maxElementLambda() {
        List<String> reusltsList= ArrayListBasic.changeList(inputStringList);
        Assert.assertEquals(reusltsList, actualStringList);
    }

}