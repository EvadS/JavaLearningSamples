package com.soapbox.basenode.consensus.transactions;

import com.soapbox.basenode.utils.RLPUtils;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLP;
import net.consensys.cava.rlp.RLPException;
import net.consensys.cava.rlp.RLPReader;
import net.consensys.cava.rlp.RLPWriter;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class VRS implements RLPSerialise {
    private RLPElement v;
    private RLPElement r;
    private RLPElement s;

    public VRS(RLPElement v, RLPElement r, RLPElement s) {
        requireNonNull(v);
        this.v = v;
        requireNonNull(r);
        this.r = r;
        requireNonNull(s);
        this.s = s;
    }

    public static boolean isNullOrEmptyOrWhitespace(VRS vrs) {
        return RLPElement.isNullOrEmptyOrWhitespace(vrs.getV())
                || RLPElement.isNullOrEmptyOrWhitespace(vrs.getR())
                || RLPElement.isNullOrEmptyOrWhitespace(vrs.getS());
    }

    public static VRS fromBytes(Bytes encoded) throws RLPException {
        requireNonNull(encoded);

        VRS.validateBytesVRS(encoded);
        VRS vrs = RLP.decode(encoded, VRS::readFrom);
        return vrs;
    }

    public static void validateBytesVRS(Bytes bytes) {
        if (bytes.isEmpty())
            throw new RLPException("Encoded strings should be not empty.");

        if (bytes.isZero()) {
            throw new RLPException("Encoded strings should not contains only zeros.");
        }
        if (RLPUtils.isWhitespaces(bytes)) {
            throw new RLPException("Encoded strings should not contains only whitespaces.");
        }
    }

    public static VRS readFrom(RLPReader reader) throws RLPException {
        try {
            Bytes bytesV = reader.readValue();
            Bytes bytesR = reader.readValue();
            Bytes bytesS = reader.readValue();
            return new VRS(RLPElement.fromBytes(bytesV), RLPElement.fromBytes(bytesR), RLPElement.fromBytes(bytesS));
        } catch (RLPException ex) {
            throw new RLPException(ex.getMessage());
        }
    }

    public RLPElement getV() {
        return v;
    }

    public RLPElement getR() {
        return r;
    }

    public RLPElement getS() {
        return s;
    }

    @Override
    public Bytes getBytes() {
        return RLP.encode(this::writeTo);
    }

    private void writeTo(RLPWriter rlpWriter) {
        rlpWriter.writeValue(v.getBytes());
        rlpWriter.writeValue(r.getBytes());
        rlpWriter.writeValue(s.getBytes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VRS vrs = (VRS) o;
        return Objects.equals(v, vrs.v) &&
                Objects.equals(r, vrs.r) &&
                Objects.equals(s, vrs.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v, r, s);
    }
}