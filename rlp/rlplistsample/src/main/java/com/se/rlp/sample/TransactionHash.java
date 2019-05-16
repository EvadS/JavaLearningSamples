package com.se.rlp.sample;

import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPReader;
import net.consensys.cava.rlp.RLPWriter;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class TransactionHash {

    private Bytes bytes;

    public TransactionHash(Bytes bytes) {
        requireNonNull(bytes);
        this.bytes = bytes;
    }

    public static TransactionHash fromBytes(Bytes encoded) {
        requireNonNull(encoded);
        return RLP.decode(encoded, TransactionHash :: readFrom);
    }

    public static TransactionHash readFrom(RLPReader rlpReader) {
        Bytes bytes = rlpReader.readValue();

        return new TransactionHash(bytes);
    }

    public Bytes getBytes() {
        return RLP.encode(this :: writeTo);
    }

    private void writeTo(RLPWriter rlpWriter) {
        rlpWriter.writeValue(bytes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionHash that = (TransactionHash) o;
        return Objects.equals(bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bytes);
    }

    @Override
    public String toString() {
        return "TransactionHash{" + "bytes=" + bytes + '}';
    }

    public void setBytes(Bytes bytes) {
        this.bytes = bytes;
    }

    public static void readFrom2(RLPReader rlpReader, List<Object> objects) {
    }
}
