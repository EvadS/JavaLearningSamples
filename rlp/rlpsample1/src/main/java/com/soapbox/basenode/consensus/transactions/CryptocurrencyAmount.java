package com.soapbox.basenode.consensus.transactions;

import net.consensys.cava.bytes.Bytes;

import java.math.BigInteger;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class CryptoCurrencyAmount implements RLPSerialise {

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
    public Bytes getBytes() {
        return Bytes.wrap(value.toByteArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CryptoCurrencyAmount that = (CryptoCurrencyAmount) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}