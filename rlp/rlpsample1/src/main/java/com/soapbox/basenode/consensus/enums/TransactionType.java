package com.soapbox.basenode.consensus.enums;

import com.soapbox.basenode.consensus.transactions.RLPSerialise;
import net.consensys.cava.bytes.Bytes;

public enum TransactionType {
    Transfer((byte) 1),
    FundsBlock((byte) 2),
    FundsUnblock((byte) 3),
    FundsWithdrawal((byte) 4),
    Obligations((byte) 5),
    QueueSkipping((byte) 6);

    private byte code;

    TransactionType(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }

    public byte[] asByteArray(){
        byte[]codeArray = {code};
        return  codeArray;
    }


    public static TransactionType fromByte(byte element) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.code == element) {
                return transactionType;
            }
        }
        return null;
    }


}