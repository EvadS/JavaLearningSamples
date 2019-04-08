package com.soapbox.basenode.consensus.transactions;

import com.soapbox.basenode.consensus.enums.TransactionParseException;
import com.soapbox.basenode.consensus.enums.TransactionType;
import net.consensys.cava.bytes.Bytes;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TransactionRLP implements RLPSerialise {

    private static final short ONE_BYTE_SIZE = 1;
    private static final short FIRST_ELEMENT = 0;

    private byte transactionType;
    private Bytes transaction;

    public TransactionRLP(TransactionType transactionType, Bytes transactions) {
        this.transactionType = transactionType.getCode();
        this.transaction = transactions;
    }

    public static TransactionRLP fromBytes(Bytes transactionBytes) throws TransactionParseException {

        if (transactionBytes.isZero() || transactionBytes.isEmpty() ) {
            throw new TransactionParseException("Nothing to parse. Input bytes has incorrect length.");
        }

        byte [] transactionArray = transactionBytes.toArray();
        TransactionType currType = TransactionType.fromByte(transactionArray[FIRST_ELEMENT]);
        byte[] transactionsArray = Arrays.copyOfRange(transactionArray, ONE_BYTE_SIZE, transactionBytes.size());

        return new TransactionRLP(currType, Bytes.wrap(transactionsArray));
    }

    public  void validate() throws TransactionParseException {

        if (transaction == null || transaction.isZero() || transaction.isEmpty()) {
            throw new TransactionParseException("Transactions array doesn't contains any transaction.");
        }
    }

    public byte getTransactionType() {
        return transactionType;
    }

    public Bytes getTransaction() {
        return transaction;
    }

    @Override
    public Bytes getBytes() {

        byte[] transactionArray = transaction.toArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(ONE_BYTE_SIZE + transactionArray.length);
        byteBuffer.put(transactionType).put(transactionArray);

        return Bytes.wrap(byteBuffer.array());
    }
}