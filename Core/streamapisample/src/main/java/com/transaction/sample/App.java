package com.transaction.sample;

import java.util.*;

public class App {
    public static void main( String[] args ) {
        List<Transaction> transactionList = new ArrayList<>();

        Collections.addAll(transactionList,
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction(),
                TransactionHelper.createTransaction());

       Transaction transaction =  TransactionHelper.getTransactionWithMaxNumber(transactionList);

       int a =10;

        System.out.println("Press any key to continue .....");
        Scanner s = new Scanner(System.in);
        System.out.println(s.next());
    }
}
