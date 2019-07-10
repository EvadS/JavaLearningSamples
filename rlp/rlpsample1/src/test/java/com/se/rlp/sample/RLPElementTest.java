package com.se.rlp.sample;

import com.soapbox.basenode.consensus.transactions.RLPElement;
import net.consensys.cava.bytes.Bytes;
import org.junit.Assert;
import org.junit.Test;

public class RLPElementTest {
    private byte[] array = "array".getBytes();
    private RLPElement rlpElement;

    @Test
    public void should_parse_unparse() {
        rlpElement = new RLPElement(array);

        Bytes rlpBytes = rlpElement.getBytes();
        RLPElement resultRlp = RLPElement.fromBytes(rlpBytes);
        Assert.assertEquals(rlpElement, resultRlp);
    }
}
