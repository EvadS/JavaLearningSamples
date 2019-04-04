package com.soapbox.basenode.consensus.transactions;

import com.com.soapbox.basenode.consensus.accounts.Address;
import com.soapbox.basenode.consensus.enums.TransactionType;
import com.soapbox.basenode.consensus.exception.IncorrectTransactionException;
import com.soapbox.basenode.utils.RLPUtils;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPException;
import net.consensys.cava.rlp.RLPWriter;

import java.math.BigInteger;

import static java.util.Objects.requireNonNull;

public abstract class Transaction implements RLPSerialise {

    public final TransactionType transactionType;
    private Address to;
    private CryptocurrencyAmount value;
    private CryptocurrencyAmount commission;

    private long created;
    private long timeOut;
    private RLPElement data;

    private VRS vrs;
    private boolean isFinished;


    protected Transaction(TransactionType transactionType, Address to, CryptocurrencyAmount value, CryptocurrencyAmount commission,
                          long created, long timeOut, RLPElement data, VRS vrs) {
        this.transactionType = transactionType;

        requireNonNull(to);
        this.to = to;

        if (value == null) {
            value = new CryptocurrencyAmount(BigInteger.ZERO);
        }
        this.value = value;

        if (commission == null) {
            commission = new CryptocurrencyAmount(BigInteger.ZERO);
        }
        this.commission = commission;

        this.created = created;
        this.timeOut = timeOut;

        if (data == null) {
            data = RLPElement.fromBytes(Bytes.EMPTY);
        }
        this.data = data;

        requireNonNull(to);
        this.vrs = vrs;
    }

    protected static void validateRLP(Bytes encoded) {
        if (encoded.isEmpty())
            throw new RLPException("Encoded strings should be not empty.");

        if (encoded.isZero()) {
            throw new RLPException("Encoded strings should not contains only zeros.");
        }
        if (RLPUtils.isWhitespaces(encoded)) {
            throw new RLPException("Encoded strings should not contains only whitespaces.");
        }
    }

    public void finish() throws IncorrectTransactionException {
        validate();
        isFinished = true;
    }

    public void validate() throws IncorrectTransactionException {
        if (isFinished) {
            throw new IncorrectTransactionException("Transaction was finished");
        }

        if (VRS.isNullOrEmptyOrWhitespace(vrs)) {
            throw new IncorrectTransactionException("The signature elements of the elliptic cryptography [V, R, S] is required.");
        }

        long currentTime = System.currentTimeMillis();
        if (created + timeOut < currentTime) {
            throw new IncorrectTransactionException("The transaction timeout has expired.");
        }
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public void setValue(CryptocurrencyAmount value) {
        this.value = value;
    }

    public void setCommission(CryptocurrencyAmount commission) {
        this.commission = commission;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public void setData(RLPElement data) {
        this.data = data;
    }

    public void setVrs(VRS vrs) {
        this.vrs = vrs;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public Bytes getBytes() {
        return RLP.encodeList(this::writeTo);
    }

    private void writeTo(RLPWriter writer) {
        writer.writeByte(transactionType.getCode());
        writer.writeByteArray(to.toBytes());

        if (value == null) {
            value = new CryptocurrencyAmount(BigInteger.ZERO);
        }
        writer.writeBigInteger(value.getValue());

        if (commission == null) {
            commission = new CryptocurrencyAmount(BigInteger.ZERO);
        }
        writer.writeBigInteger(commission.getValue());

        writer.writeLong(created);
        writer.writeLong(timeOut);
        writer.writeByteArray((RLPElement.isNullOrEmptyOrWhitespace(data)) ? data.getArray() : Bytes.EMPTY.toArray());
        writer.writeValue(vrs.getBytes());
    }

//    public static Transfer fromBytes(Bytes encoded) {
//        Transaction.validateRLP(encoded);
//
//        return RLP.decode(encoded, Transaction::readFrom);
//
//    }

    public static class TransactionBuilder {

    }
}
