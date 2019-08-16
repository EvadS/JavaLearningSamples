package com.transaction.sample;

import java.util.*;

public class App {
    public static void main( String[] args ) {

        List<Transaction> transactionList = new ArrayList<>();

        Collections.addAll(transactionList,
                TransactionHelper.createTransaction(1),
                TransactionHelper.createTransaction(2),
                TransactionHelper.createTransaction(3),
                TransactionHelper.createTransaction(4),
                TransactionHelper.createTransaction(5),
                TransactionHelper.createTransaction(6),
                TransactionHelper.createTransaction(7),
                TransactionHelper.createTransaction(8),
                TransactionHelper.createTransaction(9),

                TransactionHelper.createTransaction(11),
                TransactionHelper.createTransaction(12),
                TransactionHelper.createTransaction(13),
                TransactionHelper.createTransaction(14),
                TransactionHelper.createTransaction(15),
                TransactionHelper.createTransaction(16),
                TransactionHelper.createTransaction(17),
                TransactionHelper.createTransaction(18),
                TransactionHelper.createTransaction(11119),

                TransactionHelper.createTransaction(10));


        Transaction trns =  TransactionHelper.getTransactionWithMaxNumber1(transactionList);
       // TransactionHelper.print(transactionList);

        List<Transaction>  res = TransactionHelper.cleanTransactionsWithMinimalCommission(transactionList,9);

     //   System.out.println("After: ");
      //  TransactionHelper.print(res);


       Transaction transaction =  TransactionHelper.getTransactionWithMaxNumber(transactionList);

       int a =10;

        System.out.println("Press any key to continue .....");
        Scanner s = new Scanner(System.in);
        System.out.println(s.next());


    }
}
