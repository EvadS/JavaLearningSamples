package com.soapbox.basenode.utils;


import com.soapbox.basenode.consensus.transactions.RLPElement;
import net.consensys.cava.bytes.Bytes;

public class RLPUtils {

    public static boolean isWhitespaces(Bytes bytes) {
        byte[] bytesArray = bytes.toArray();

        for (int i = 0; i < bytesArray.length; i++) {
            if (!Character.isWhitespace(bytesArray[i])) {
                return false;
            }
        }

        return true;
    }
}
