package com.soap.box.address.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
public class BackEndAwards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private byte transactionType;

    @NotNull
    private String addressTo;

    @NotNull
    private BigInteger amount;

    @NotNull
    private BigInteger commission;

    @NotNull
    private long created;

    @NotNull
    private long timeOut;

    private byte[] transactionPurpose;

    private long commentId;

    private boolean isDone;


    public BackEndAwards() {
    }

    public BackEndAwards(@NotNull byte transactionType, @NotNull String addressTo, @NotNull BigInteger amount, @NotNull BigInteger commission, @NotNull long created, @NotNull long timeOut, byte[] transactionPurpose, long commentId) {
        this.transactionType = transactionType;
        this.addressTo = addressTo;
        this.amount = amount;
        this.commission = commission;
        this.created = created;
        this.timeOut = timeOut;
        this.transactionPurpose = transactionPurpose;
        this.commentId = commentId;
        this.isDone = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(byte transactionType) {
        this.transactionType = transactionType;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getCommission() {
        return commission;
    }

    public void setCommission(BigInteger commission) {
        this.commission = commission;
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

    public byte[] getTransactionPurpose() {
        return transactionPurpose;
    }

    public void setTransactionPurpose(byte[] transactionPurpose) {
        this.transactionPurpose = transactionPurpose;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
