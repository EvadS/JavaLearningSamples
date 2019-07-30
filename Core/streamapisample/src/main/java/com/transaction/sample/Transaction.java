package com.transaction.sample;

public class Transaction {
    protected UnsignedTransaction unsignedTransaction;
    private String vrs;

    public Transaction(UnsignedTransaction unsignedTransaction, String vrs) {
        this.unsignedTransaction = unsignedTransaction;
        this.vrs = vrs;
    }

    public UnsignedTransaction getUnsignedTransaction() {
        return unsignedTransaction;
    }

    public String getVrs() {
        return vrs;
    }
}
