package com.se.sample.gsconsumingrest.model;

import java.util.Objects;

public class TransactionItemResponse {
    private String encodedTransaction;
    private long executedTime;
    private boolean incomeTransaction;
    private boolean success;

    public TransactionItemResponse() {
    }

    public TransactionItemResponse(String encodedTransaction, long executedTime, boolean incomeTransaction, boolean success) {
        this.encodedTransaction = encodedTransaction;
        this.executedTime = executedTime;
        this.incomeTransaction = incomeTransaction;
        this.success = success;
    }

    public String getEncodedTransaction() {
        return encodedTransaction;
    }

    public void setEncodedTransaction(String encodedTransaction) {
        this.encodedTransaction = encodedTransaction;
    }

    public long getExecutedTime() {
        return executedTime;
    }

    public void setExecutedTime(long executedTime) {
        this.executedTime = executedTime;
    }

    public boolean isIncomeTransaction() {
        return incomeTransaction;
    }

    public void setIncomeTransaction(boolean incomeTransaction) {
        this.incomeTransaction = incomeTransaction;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionItemResponse that = (TransactionItemResponse) o;
        return executedTime == that.executedTime &&
                incomeTransaction == that.incomeTransaction &&
                success == that.success &&
                Objects.equals(encodedTransaction, that.encodedTransaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encodedTransaction, executedTime, incomeTransaction, success);
    }

    @Override
    public String toString() {
        return "TransactionItemResponse{" +
                "encodedTransaction='" + encodedTransaction + '\'' +
                ", executedTime=" + executedTime +
                ", incomeTransaction=" + incomeTransaction +
                ", success=" + success +
                '}';
    }
}
