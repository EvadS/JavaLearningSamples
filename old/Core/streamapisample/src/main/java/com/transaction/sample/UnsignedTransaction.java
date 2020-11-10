package com.transaction.sample;

import java.math.BigInteger;

public class UnsignedTransaction {

    private long created;
    private long timeOut;
    private BigInteger number;
    private BigInteger commission;

    /**
     *
     * @param created
     * @param timeOut
     * @param number
     */
    public UnsignedTransaction(long created, long timeOut, BigInteger number,BigInteger commission) {
        this.created = created;
        this.timeOut = timeOut;
        this.number = number;
        this.commission  = commission;
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

    public BigInteger getCommission() {
        return commission;
    }

    public void setCommission(BigInteger commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return    "created=" + created +
                ", timeOut=" + timeOut +
                ", number=" + number +
                ", commission=" + commission ;
    }
}
