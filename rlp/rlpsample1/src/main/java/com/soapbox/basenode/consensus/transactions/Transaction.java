package com.soapbox.basenode.consensus.transactions;

import com.com.soapbox.basenode.consensus.accounts.Address;
import com.soapbox.basenode.consensus.enums.TransactionParseException;
import com.soapbox.basenode.consensus.enums.TransactionType;
import com.soapbox.basenode.consensus.exception.IncorrectTransactionException;
import com.soapbox.basenode.utils.BigintegerUtils;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPWriter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigInteger;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public abstract class Transaction implements RLPSerialise {

    public final TransactionType transactionType;
    private Address to;
    private CryptoCurrencyAmount value;
    private CryptoCurrencyAmount commission;

    private long created;
    private long timeOut;
    private RLPElement data;

    private VRS vrs;
    private boolean isFinished;

//    public TransactionHash buildTransactionHash() {
//        byte[] array = getRLPData();
//        return new TransactionHash(CryptoHolder.getInstance().getHash(array));
//    }

    //TODO: remove public !! now for test
    public Transaction(TransactionType transactionType, Address to, CryptoCurrencyAmount value,
                       CryptoCurrencyAmount commission,
                       long created, long timeOut, RLPElement data, VRS vrs) {
        this.transactionType = transactionType;

        requireNonNull(to);

        this.to = to;

        if (value == null) {
            value = new CryptoCurrencyAmount(BigInteger.ZERO);
        }
        this.value = value;

        if (commission == null) {
            commission = new CryptoCurrencyAmount(BigInteger.ZERO);
        }
        this.commission = commission;

        this.created = created;
        this.timeOut = timeOut;

        if (data == null) {
            data = RLPElement.fromBytes(Bytes.EMPTY);
        }
        this.data = data;

        requireNonNull(vrs);
        this.vrs = vrs;
    }

    public static Transaction parse(TransactionRLP transactionRLP) throws TransactionParseException {
        transactionRLP.validate();
        TransactionType currTransType = TransactionType.fromByte(transactionRLP.getTransactionType());

        switch (currTransType) {
            case Transfer: {
                return Transfer.fromBytes(transactionRLP.getTransaction());
            }

            default:
                throw new TransactionParseException("Unknown transaction type.");
        }
    }


    public void finish() throws IncorrectTransactionException {
        validate();
        isFinished = true;
    }

    public void validate() throws IncorrectTransactionException {
        if (isFinished) {
            throw new IncorrectTransactionException("Transaction was finished.");
        }

        if (VRS.isNullOrEmptyOrWhitespace(vrs)) {
            throw new IncorrectTransactionException("The signature elements of the elliptic cryptography [V, R, S] is required.");
        }

        long currentTime = System.currentTimeMillis();
        if (created + timeOut < currentTime) {
            throw new IncorrectTransactionException("The transaction timeout has expired.");
        }
    }

    public Address getTo() {
        return to;
    }

    public CryptoCurrencyAmount getValue() {
        return value;
    }

    public void setValue(CryptoCurrencyAmount value) {
        if (isFinished) {
            return;
        }
        this.value = value;
    }

    public CryptoCurrencyAmount getCommission() {
        return commission;
    }

    public void setCommission(CryptoCurrencyAmount commission) {
        if (isFinished) {
            return;
        }
        this.commission = commission;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        if (isFinished) {
            return;
        }
        this.created = created;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        if (isFinished) {
            return;
        }
        this.timeOut = timeOut;
    }

    public RLPElement getData() {
        return data;
    }

    public void setData(RLPElement data) {
        if (isFinished) {
            return;
        }
        this.data = data;
    }

    public VRS getVrs() {
        return vrs;
    }

    public void setVrs(VRS vrs) {
        if (isFinished) {
            return;
        }
        this.vrs = vrs;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        if (isFinished) {
            return;
        }
        isFinished = finished;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public Bytes getBytes() {
        return RLP.encode(this::writeTo);
    }

    private void writeTo(RLPWriter writer) {
        writer.writeByteArray(to.toBytes());

        if (value == null) {
            value = new CryptoCurrencyAmount(BigInteger.ZERO);
        }
        writer.writeValue(value.getBytes());

        if (commission == null) {
            commission = new CryptoCurrencyAmount(BigInteger.ZERO);
        }
        writer.writeValue(commission.getBytes());

        writer.writeLong(created);
        writer.writeLong(timeOut);
        writer.writeValue((RLPElement.isNullOrEmptyOrWhitespace(data)) ? data.getBytes() : Bytes.EMPTY);
        writer.writeValue(vrs.getBytes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return Objects.equals(to, transaction.to) &&
                Objects.equals(value, transaction.value) &&
                Objects.equals(commission, transaction.commission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to);
    }

    public static class TransactionBuilder {
        TransactionType transactionType;
        private Address to;
        private CryptoCurrencyAmount value;
        private CryptoCurrencyAmount commission;
        private RLPElement data;
        private long created;
        private long timeOut;
        private VRS vrs;

        public TransactionBuilder withBaseInfo(TransactionType transactionType, Address to, CryptoCurrencyAmount value,
                                               CryptoCurrencyAmount commission, long created, long timeOut,
                                               RLPElement data) throws IncorrectTransactionException {

            validateBaseFields(to,value, commission, created, timeOut, data);


            this.to = to;
            this.data = data;
            this.value = value;
            this.commission = commission;
            this.created = created;
            this.timeOut = timeOut;
            this.transactionType = transactionType;

            return this;
        }

        // we are use this method to confirm the transaction
        public TransactionBuilder signTransaction(RLPElement v, RLPElement r, RLPElement s)
                throws IncorrectTransactionException {
            validateBaseFields(this.to,this.value, this.commission, this.created, this.timeOut, this.data);

            //TODO: should add validate!
            validateVRS(v, r, s);

            // set V,R,S
            this.vrs = new VRS(v, r, s);
            return this;
        }

        public Transaction build() {
            switch (this.transactionType) {
                case Transfer: {
                    return new Transfer(to, value, commission, created, timeOut, data, vrs);
                }
            }
            throw new NotImplementedException();
        }

        private void validateBaseFields(Address to,CryptoCurrencyAmount value, CryptoCurrencyAmount commission, long created, long timeOut, RLPElement data) throws IncorrectTransactionException {

            to.validate();

            if (RLPElement.isNullOrEmptyOrWhitespace(data)) {
                throw new IncorrectTransactionException("'data' is required value for build transaction.");
            }

            if (BigintegerUtils.isLessThanZero(value.getValue())) {
                throw new IncorrectTransactionException("The minimum of 'value' is zero.");
            }

            if (created < 0)
                throw new IncorrectTransactionException("Incorrect value for field 'created'.");

            if (timeOut < 0)
                throw new IncorrectTransactionException("Incorrect value for field 'timeOut'.");

            if (BigintegerUtils.isLessThanZero(commission.getValue())) {
                throw new IncorrectTransactionException("The minimum of 'commission' is zero.");
            }
        }

        private void validateVRS(RLPElement v, RLPElement r, RLPElement s) throws IncorrectTransactionException {
            if (RLPElement.isNullOrEmptyOrWhitespace(v)) {
                throw new IncorrectTransactionException("The signature elements 'v' of the elliptic cryptography [V, R, S] is required.");
            }

            if (RLPElement.isNullOrEmptyOrWhitespace(r)) {
                throw new IncorrectTransactionException("The signature elements 'r' of the elliptic cryptography [V, R, S] is required.");
            }

            if (RLPElement.isNullOrEmptyOrWhitespace(s)) {
                throw new IncorrectTransactionException("The signature elements 's' of the elliptic cryptography [V, R, S] is required.");
            }
        }


    }

}
