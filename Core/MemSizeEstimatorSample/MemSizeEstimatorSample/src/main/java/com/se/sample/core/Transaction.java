package com.se.sample.core;

import com.se.sample.datasource.MemSizeEstimator;

import java.math.BigInteger;

import static com.se.sample.datasource.MemSizeEstimator.ByteArrayEstimator;

public class Transaction {
    private static final BigInteger DEFAULT_GAS_PRICE = new BigInteger("10000000000000");
    private static final BigInteger DEFAULT_BALANCE_GAS = new BigInteger("21000");

    /* SHA3 hash of the RLP encoded transaction */
    private byte[] hash;

    /* a counter used to make sure each transaction can only be processed once */
    private byte[] nonce;

    /* the amount of ether to transfer (calculated as wei) */
    private byte[] value;

    public static final MemSizeEstimator<Transaction> MemEstimator = tx ->
            ByteArrayEstimator.estimateSize(tx.hash) +
                    ByteArrayEstimator.estimateSize(tx.nonce) +
                    ByteArrayEstimator.estimateSize(tx.value) +

                    16; // Object header + ref
}

