package com.soapbox.basenode.consensus.transactions;

import com.com.soapbox.basenode.consensus.accounts.Address;
import com.com.soapbox.basenode.consensus.accounts.ParseException;
import com.soapbox.basenode.consensus.enums.TransactionType;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPException;
import net.consensys.cava.rlp.RLPReader;

import java.math.BigInteger;

public class Transfer extends Transaction {


    //TODO: remove !! now for test
    public Transfer(Address to, CryptoCurrencyAmount value, CryptoCurrencyAmount commission, long created, long timeOut, RLPElement data, VRS vrs) {
        super(TransactionType.Transfer, to, value, commission, created, timeOut, data, vrs);
    }

    public static Transaction fromBytes(Bytes encoded) {
        VRS.validateBytesVRS(encoded);
        return RLP.decode(encoded, Transfer::readFrom);
    }

    private static Transaction readFrom(RLPReader rlpReader) {
        Bytes bytesV = rlpReader.readValue();

        Address address;
        try {
            address = new Address(bytesV.toArray());
        } catch (IllegalArgumentException e) {
            throw new RLPException("Value is the wrong size to be an address", e);
        } catch (ParseException e) {
            throw new RLPException("Value is the wrong size to be an address", e);
        }

        BigInteger value = rlpReader.readBigInteger();
        CryptoCurrencyAmount valueAmount = new CryptoCurrencyAmount(value);

        BigInteger commission = rlpReader.readBigInteger();
        CryptoCurrencyAmount commissionAmount = new CryptoCurrencyAmount(commission);


        Long created = rlpReader.readLong();
        Long timeOut = rlpReader.readLong();

        Bytes dataBytes = rlpReader.readValue();
        RLPElement rlpData = RLPElement.fromBytes(dataBytes);

        Bytes vrsBytes = rlpReader.readValue();
        VRS vrs = VRS.fromBytes(vrsBytes);
        return new Transfer(address, valueAmount, commissionAmount, created, timeOut, rlpData, vrs);
    }

    public Bytes getTransactionRLPBytes() {
        Bytes array = getBytes();
        TransactionRLP transactionRLP = new TransactionRLP(transactionType, getBytes());
        return transactionRLP.getBytes();
    }



}
