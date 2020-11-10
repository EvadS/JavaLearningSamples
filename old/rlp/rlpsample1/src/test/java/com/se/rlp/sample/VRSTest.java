package com.se.rlp.sample;

import com.soapbox.basenode.consensus.transactions.RLPElement;
import com.soapbox.basenode.consensus.transactions.VRS;
import net.consensys.cava.bytes.Bytes;
import net.consensys.cava.rlp.RLPException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

public class VRSTest {

    private final byte[] v = "v".getBytes();
    private final byte[] r = "r".getBytes();
    private final byte[] s = "s".getBytes();

    private final byte[] whiteSpacesByteArray = "".getBytes();
    private final byte[] zeroArray = new byte[0];

    Bytes bytesV;
    Bytes bytesR;
    Bytes bytesS;

    private RLPElement rlpV;
    private RLPElement rlpR;
    private RLPElement rlpS;
    private RLPElement zeroRLP;
    private RLPElement emptyRLP;
    private VRS vrs;

    @Before
    public void init() {
        bytesV = Bytes.wrap(v);
        bytesR = Bytes.wrap(r);
        bytesS = Bytes.wrap(s);

        rlpV = RLPElement.fromBytes(bytesV);
        rlpR = RLPElement.fromBytes(bytesR);
        rlpS = RLPElement.fromBytes(bytesS);

        // for next Test
      //  zeroRLP = RLPElement.fromBytes(Bytes.EMPTY);
       // emptyRLP = RLPElement.fromBytes(Bytes.wrap(whiteSpacesByteArray));
    }

    @Test(expected = NullPointerException.class)
    public void should_not_corect_work_vrs() {
        VRS localVRS = new VRS(null, null, null);
    }

    @Test
    public void is_zero_corect_work_vrs() {
        VRS localVRS = new VRS(rlpV, rlpR, rlpS);
        Assert.assertEquals(false, VRS.isNullOrEmptyOrWhitespace(localVRS));
    }

    @Test
    public void is_correct_parse_unparsed() {
        VRS sourceVRS = new VRS(rlpV, rlpR, rlpS);

        Bytes bytes = sourceVRS.getBytes();
        VRS resultVRS = VRS.fromBytes(bytes);
        Assert.assertEquals(sourceVRS, resultVRS);
    }


    @Test(expected = NullPointerException.class)
    public void should_correct_parse_null() {
        byte[] inputArray = null;
        Bytes bytes = Bytes.wrap(inputArray);

        VRS resultVRS = VRS.fromBytes(bytes);
    }

    @Test(expected = NullPointerException.class)
    public void should_correct_create_null_v() {
        byte[] inputArray = null;
        VRS resultVRS = new VRS(null, rlpR, rlpS);
    }

    @Test(expected = NullPointerException.class)
    public void should_correct_create_null_r() {
        byte[] inputArray = null;
        VRS resultVRS = new VRS(rlpV, null, rlpS);
    }

    //fromBytes
    @Test
    public void should_correct_parse_from_rlp() {
        // The situation when wew have correct data from network
        ByteBuffer bb = ByteBuffer.allocate(v.length + r.length + s.length);
        bb.put(v).put(r).put(s);
        byte[] result = bb.array();

        Bytes rBytes = Bytes.wrap(result);
        VRS resultVRS = VRS.fromBytes(rBytes);

        Assert.assertEquals(resultVRS.getV(), rlpV);
        Assert.assertEquals(resultVRS.getR(), rlpR);
        Assert.assertEquals(resultVRS.getS(), rlpS);
    }

    @Test(expected = NullPointerException.class)
    public void fromBytes_should_correct_parse_null() {
        byte[] array = null;
        Bytes bytes = Bytes.wrap(array);

        VRS resultVRS = VRS.fromBytes(bytes);
    }

    @Test(expected = RLPException.class)
    public void fromBytes_should_correct_parse_v_r_null() {
        ByteBuffer bb = ByteBuffer.allocate(v.length + r.length);
        bb.put(r).put(s);
        byte[] bbArray = bb.array();

        Bytes bytes = Bytes.wrap(bbArray);

        VRS resultVRS = VRS.fromBytes(bytes);
    }

    @Test(expected = RLPException.class)
    public void fromBytes_should_correct_parse_arrays_whiteSpacesByteArray() {
        ByteBuffer bb = ByteBuffer.allocate(whiteSpacesByteArray.length + whiteSpacesByteArray.length + whiteSpacesByteArray.length);
        bb.put(whiteSpacesByteArray).put(whiteSpacesByteArray).put(whiteSpacesByteArray);
        byte[] bbArray = bb.array();

        Bytes bytes = Bytes.wrap(bbArray);

        VRS resultVRS = VRS.fromBytes(bytes);
    }

    @Test(expected = RLPException.class)
    public void fromBytes_should_correct_parse_whiteSpacesByteArray() {
        ByteBuffer bb = ByteBuffer.allocate(whiteSpacesByteArray.length);
        bb.put(whiteSpacesByteArray);
        byte[] bbArray = bb.array();

        Bytes bytes = Bytes.wrap(bbArray);

        VRS resultVRS = VRS.fromBytes(bytes);
    }

    @Test(expected = RLPException.class)
    public void fromBytes_should_correct_parse_zero() {
        ByteBuffer bb = ByteBuffer.allocate(0);
        bb.put(zeroArray);
        byte[] bbArray = bb.array();

        Bytes bytes = Bytes.wrap(bbArray);

        VRS resultVRS = VRS.fromBytes(bytes);
    }
}
