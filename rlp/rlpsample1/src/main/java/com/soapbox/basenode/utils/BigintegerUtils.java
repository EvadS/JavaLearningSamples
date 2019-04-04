package com.soapbox.basenode.utils;

import java.math.BigInteger;

public class BigintegerUtils {
    public static boolean isZero(BigInteger value){
        return value.compareTo(BigInteger.ZERO) == 0;
    }

    public static boolean isEqual(BigInteger valueA, BigInteger valueB){
        return valueA.compareTo(valueB) == 0;
    }

    public static boolean isNotEqual(BigInteger valueA, BigInteger valueB){
        return !isEqual(valueA, valueB);
    }

    public static boolean isLessThan(BigInteger valueA, BigInteger valueB){
        return valueA.compareTo(valueB) < 0;
    }

    public static boolean isLessThanZero(BigInteger valueA)
    {
        return valueA.compareTo(BigInteger.ZERO) < 0;
    }
}
