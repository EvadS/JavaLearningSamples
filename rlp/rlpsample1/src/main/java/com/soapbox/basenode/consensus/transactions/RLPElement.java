package com.soapbox.basenode.consensus.transactions;

import net.consensys.cava.bytes.Bytes;
import java.util.Arrays;
import static java.util.Objects.requireNonNull;

public class RLPElement implements RLPSerialise {
    private static final int ZERO_BYTE_LEN = 0;

    private final byte[] array;

    public RLPElement(byte[] value) {
        this.array = value;
    }

    public static RLPElement fromBytes(Bytes bytes) {
        requireNonNull(bytes);
        return new RLPElement(bytes.toArray());
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

    @Override
    public Bytes getBytes() {
        return Bytes.wrap(array);
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

    public byte[] getArray() {
        return array;
    }
}