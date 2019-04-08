package com.soapbox.basenode.consensus.transactions;

import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPReader;
import net.consensys.cava.rlp.RLPWriter;

import java.util.Arrays;

public class RLPElement implements RLPSerialise {
    private static final int ZERO_BYTE_LEN = 0;

    private final byte[] array;

    public RLPElement(byte[] value) {
        this.array = value;
    }

    public static RLPElement fromBytes(Bytes encoded) {
        VRS.validateBytesVRS(encoded);
        return RLP.decode(encoded, RLPElement::readFrom);
    }
    private static RLPElement readFrom(RLPReader rlpReader) {
        Bytes element = rlpReader.readValue();
        return new RLPElement(element.toArray());
    }

    public static boolean isNullOrEmptyOrWhitespace(RLPElement element) {
        if (element.array == null || element.array.length == ZERO_BYTE_LEN) {
            return true;
        }

        return element.array.length == ZERO_BYTE_LEN || isWhitespaces(element);
    }

    public static boolean isWhitespaces(RLPElement value) {
        for (int i = 0; i < value.array.length; i++) {
            if (!Character.isWhitespace(value.array[i])) {
                return false;
            }
        }
        return true;
    }

//    @Override
//    public Bytes getBytes() {
//        return Bytes.wrap(array);
//    }


    @Override
    public Bytes getBytes() {
        return RLP.encode(this::writeTo);
    }

    private void writeTo(RLPWriter writer) {
        writer.writeByteArray(array);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RLPElement that = (RLPElement) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    // public byte[] getArray() {
    //   return array;
    // }
}