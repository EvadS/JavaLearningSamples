package com.se.sample.models;

import java.util.Arrays;

public class SegmentHash {

    protected byte[] hashValue;

    public SegmentHash(byte[] hashValue) {
        this.hashValue = hashValue;
    }

    public byte[] getHashValue() {
        return hashValue;
    }

    public void setHashValue(byte[] hashValue) {
        this.hashValue = hashValue;
    }

    @Override
    public String toString() {
        return "SegmentHash{" +
                "hashValue=" + Arrays.toString(hashValue) +
                '}';
    }
}
