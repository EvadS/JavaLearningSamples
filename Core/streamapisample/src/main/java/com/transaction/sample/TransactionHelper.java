package com.transaction.sample;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class TransactionHelper {

    private static int number = 1;

    private static UnsignedTransaction createdUnsignedTransaction() {
        UnsignedTransaction unsignedTransaction = new UnsignedTransaction(
                System.currentTimeMillis(),
                System.currentTimeMillis(),
                BigInteger.valueOf(number));
        number++;

        return unsignedTransaction;
    }

    public static Transaction createTransaction() {
        String vrs = String.format("vrs %s", System.currentTimeMillis());
        Transaction transaction = new Transaction(createdUnsignedTransaction(), vrs);
        return transaction;
    }


    public static Transaction getTransactionWithMaxNumber(List<Transaction> transactionList) {
        Transaction transaction = transactionList.stream()
                .max(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction transaction, Transaction t1) {
                        return transaction.getUnsignedTransaction().getNumber().compareTo(t1.getUnsignedTransaction().getNumber());
                    }
                }).get();

        return transaction;
    }
}
