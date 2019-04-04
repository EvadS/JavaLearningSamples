package com.soapbox.basenode.consensus.transactions;

import com.com.soapbox.basenode.consensus.accounts.Address;
import com.soapbox.basenode.consensus.enums.TransactionType;

public class Transfer extends Transaction {

    protected Transfer(Address to, CryptocurrencyAmount value, CryptocurrencyAmount commission, long created, long timeOut, RLPElement data, VRS vrs) {
        super(TransactionType.Transfer, to, value, commission, created, timeOut, data, vrs);
    }


//    private static Transfer readFrom(RLPReader rlpReader) {
//        TransactionType parentHashBytes = rlpReader.readValue();
//    }


}
