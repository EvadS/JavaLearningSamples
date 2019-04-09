package com.se.comparator.sample;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Objects;

public class CryptoCurrencyAmount implements Comparator<CryptoCurrencyAmount>, Comparable<CryptoCurrencyAmount> {
    private static final int FRACTIONAL_DELIMITER = 1000000;

    BigInteger value;

    public CryptoCurrencyAmount(BigInteger value) {
        this.value = value;
    }

    public static CryptoCurrencyAmount fromByteArray(byte[] byteArray) {
        BigInteger bgInt = new BigInteger(byteArray);
        return new CryptoCurrencyAmount(bgInt);
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    @Override
    public String toString() {
        int delimiter = FRACTIONAL_DELIMITER;
        return String.format("%d.%06d", value.divide(BigInteger.valueOf(delimiter)), value.mod(BigInteger.valueOf(delimiter)));
    }

    @Override
    public int compare(CryptoCurrencyAmount currencyAmount1, CryptoCurrencyAmount currencyAmount2) {
        return currencyAmount1.getValue().compareTo(currencyAmount2.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        CryptoCurrencyAmount that = (CryptoCurrencyAmount) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    // Compare Two CryptoCurrencyAmount based on their value

    @Override
    public int compareTo(CryptoCurrencyAmount cryptoCurrency) {
        return   this.getValue().compareTo(cryptoCurrency.getValue());
    }

    public static Comparator<CryptoCurrencyAmount> CryptoCurrencyComparator
            = new Comparator<CryptoCurrencyAmount>() {

        @Override
        public int compare(CryptoCurrencyAmount cca1, CryptoCurrencyAmount cca2) {
            return cca1.getValue().compareTo(cca2.getValue());
        }
    };


}
