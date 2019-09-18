package com.soap.box.address.entity;



import javax.persistence.*;
import java.math.BigInteger;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NodeTransactionAwards")
public class NodeTransactionAwards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private byte transactionType;

    @NotNull(message = "Address to ")
    private String addressTo;

    @NotNull(message = "amount")
    private BigInteger amount;

    @NotNull(message = "commission")
    private BigInteger commission;

    @NotNull(message = "created")
    @Min(1)
    private long created;

    @NotNull(message = "timeOut")
    @Min(1)
    private long timeOut;


    @NotNull
    private byte[] transactionPurpose;

    private boolean isDone;

    public NodeTransactionAwards() {
    }

    public NodeTransactionAwards(byte transactionType, @NotNull String addressTo, @NotNull BigInteger amount, @NotNull BigInteger commission, @NotNull @Min(1) long created, @NotNull @Min(1) long timeOut, byte[] transactionPurpose) {
        this.transactionType = transactionType;
        this.addressTo = addressTo;
        this.amount = amount;
        this.commission = commission;
        this.created = created;
        this.timeOut = timeOut;
        this.transactionPurpose = transactionPurpose;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
