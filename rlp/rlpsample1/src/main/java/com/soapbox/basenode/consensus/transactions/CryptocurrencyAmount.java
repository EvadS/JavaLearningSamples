package com.soapbox.basenode.consensus.transactions;

import net.consensys.cava.bytes.Bytes;

import java.math.BigInteger;

public class CryptocurrencyAmount implements RLPSerialise {

    private static final int FRACTIONAL_DELIMITER = 1000000;

    BigInteger value;

    public CryptocurrencyAmount(BigInteger value) {
        this.value = value;
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
}