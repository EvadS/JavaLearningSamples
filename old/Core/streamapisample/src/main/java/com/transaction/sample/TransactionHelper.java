package com.transaction.sample;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionHelper {

    private static int number = 1;

    private static UnsignedTransaction createdUnsignedTransaction(int commission) {
        UnsignedTransaction unsignedTransaction = new UnsignedTransaction(
                System.currentTimeMillis(),
                System.currentTimeMillis(),
                BigInteger.valueOf(number),
                BigInteger.valueOf(commission)                );
        number++;

        return unsignedTransaction;
    }

    public static Transaction createTransaction(int commission) {
        String vrs = String.format("vrs %s", System.currentTimeMillis());
        Transaction transaction = new Transaction(createdUnsignedTransaction(commission), vrs);
        return transaction;
    }


    /**
     * incorrect solution because we get sorted result
     * @param transactionList
     * @return
     */
    public static Transaction getTransactionWithMaxNumber1(List<Transaction> transactionList) {
        Transaction transaction = transactionList.stream()
                .max(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction transaction, Transaction t1) {
                        return transaction.getUnsignedTransaction().getNumber().compareTo(t1.getUnsignedTransaction().getNumber());
                    }
                }).get();

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
    public  static  List<Transaction> cleanTransactionsWithMinimalCommission(List<Transaction> transactionList,int removedCount){

        transactionList.removeAll(transactionList.stream()
                .sorted(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction t1, Transaction t2) {
                        return t1.getUnsignedTransaction().getCommission().compareTo(t2.getUnsignedTransaction().getCommission());
                    }
                }).limit(transactionList.size() - removedCount).collect(Collectors.toList()));

        System.out.println("transactionList with out  min commission : ");
        print(transactionList);

        return transactionList;
    }


  public  static  List<Transaction> cleanTransactionsWithMinimalCommission3(List<Transaction> transactionList,int removedCount){
       List<Transaction> result = transactionList.stream()
                .sorted(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction t1, Transaction t2) {
                        return t1.getUnsignedTransaction().getCommission().compareTo(t2.getUnsignedTransaction().getCommission());
                    }
                }).limit(transactionList.size() - removedCount).collect(Collectors.toList());

       System.out.println("result with min commission : ");
       print(result);

       transactionList.removeAll(result);

      System.out.println("transactionList with out  min commission : ");
      print(transactionList);

        return transactionList;
    }

    public static void print(List<Transaction> transactionList){
        for(Transaction transaction : transactionList){
            System.out.println(transaction.toString());
        }

    }
}
