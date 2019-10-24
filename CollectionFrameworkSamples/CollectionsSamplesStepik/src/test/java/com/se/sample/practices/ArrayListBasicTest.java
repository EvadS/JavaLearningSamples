package com.se.sample.practices;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayListBasicTest {

    private final List<Integer> input = Arrays.asList(847, 271, 663, 473, 376, 133, 693, 13, 382, 879);
    private final int actualElement = 879;

    @Test
    public void maxElem() {
        int maxelement = ArrayListBasic.maxElem(input);
        Assert.assertEquals(maxelement, actualElement);
    }
}