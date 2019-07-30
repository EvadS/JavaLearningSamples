package com.transaction.sample;

import java.math.BigInteger;

public class UnsignedTransaction {

    private long created;
    private long timeOut;
    private BigInteger number;

    /**
     *
     * @param created
     * @param timeOut
     * @param number
     */
    public UnsignedTransaction(long created, long timeOut, BigInteger number) {
        this.created = created;
        this.timeOut = timeOut;
        this.number = number;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }
}
