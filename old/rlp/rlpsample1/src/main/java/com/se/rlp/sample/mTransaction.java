package com.se.rlp.sample;

import com.soapbox.basenode.consensus.transactions.RLPElement;
import com.soapbox.basenode.consensus.transactions.VRS;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPException;
import net.consensys.cava.rlp.RLPReader;
import net.consensys.cava.rlp.RLPWriter;

import static java.util.Objects.requireNonNull;

public class mTransaction {
    private long created;
    private long timeOut;

    private RLPElement to;
    private VRS vrs;


    public mTransaction(RLPElement to, long created, long timeOut, VRS vrs) {
        this.to = to;
        this.created = created;
        this.timeOut = timeOut;
        this.vrs = vrs;
    }

    public mTransaction(RLPElement to, long created, long timeOut, Bytes v, Bytes r, Bytes s) {
        this.to = to;
        this.created = created;
        this.timeOut = timeOut;

        //TODO:
    }

    public static mTransaction fromBytes(Bytes encoded) {
        return fromBytes(encoded, false);
    }

    /**
     * Deserialize a transaction from RLP encoded bytes.
     *
     * @param encoded The RLP encoded transaction.
     * @param lenient If {@code true}, the RLP decoding will be lenient toward any non-minimal encoding.
     * @return The de-serialized transaction.
     * @throws RLPException If there is an error decoding the transaction.
     */
    public static mTransaction fromBytes(Bytes encoded, boolean lenient) {
        requireNonNull(encoded);
        return RLP.decode(encoded, (reader) -> {
            mTransaction tx = reader.readList(mTransaction::readFrom);


            if (!reader.isComplete()) {
                throw new RLPException("Additional bytes present at the end of the encoded transaction");
            }
            return tx;
        });
    }

    /**
     * Deserialize a transaction from an RLP input.
     *
     * @param reader The RLP reader.
     * @return The de-serialized transaction.
     * @throws RLPException If there is an error decoding the transaction.
     */
    public static mTransaction readFrom(RLPReader reader) {

        Bytes addressBytes = reader.readValue();
        RLPElement address;
        try {
            address = addressBytes.isEmpty() ? null : RLPElement.fromBytes(addressBytes);
        } catch (IllegalArgumentException e) {
            throw new RLPException("Value is the wrong size to be an address", e);
        }

        Long createdBytes = reader.readLong();
        Long timeOut = reader.readLong();

        Bytes v = reader.readValue();
        Bytes r = reader.readValue();
        Bytes s = reader.readValue();

        try {
            return new mTransaction(address, createdBytes, timeOut, v, r, s);
        } catch (IllegalArgumentException e) {
            throw new RLPException(e.getMessage(), e);
        }

    }

    /**
     * @return The RLP serialized form of this block header.
     */
    public Bytes toBytes() {
        return RLP.encodeList(this::writeTo);
    }

    /**
     * Write this block header to an RLP output.
     *
     * @param writer The RLP writer.
     */
    private void writeTo(RLPWriter writer) {
        writer.writeValue((to.getBytes() != null) ? to.getBytes() : Bytes.EMPTY);

        writer.writeLong(created);
        writer.writeLong(timeOut);
//        writer.writeValue(vrs.getS());
//        writer.writeValue(vrs.getR());
//        writer.writeValue(vrs.getS());
    }

    public long getCreated() {
        return created;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public RLPElement getTo() {
        return to;
    }

    public VRS getVrs() {
        return vrs;
    }
}
