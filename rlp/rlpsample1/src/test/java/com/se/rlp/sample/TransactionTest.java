package com.se.rlp.sample;

import com.soapbox.basenode.consensus.transactions.RLPElement;
import com.soapbox.basenode.consensus.transactions.VRS;
import net.consensys.cava.bytes.Bytes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

public class TransactionTest {
    private final long created = Instant.now().getEpochSecond();
    private final long timeOut = Instant.now().getEpochSecond();
    private final byte[] v = "vvvvvvvvvvvvvvvvvvvv".getBytes();
    private final byte[] r = "rrrrrrrrrrrrrrrrrrrr".getBytes();
    private final byte[] s = "ssssssssssssssssssss".getBytes();
    private final byte[] to ="tttttttttttttttttttt".getBytes();
    mTransaction transaction;
    private VRS vrs;


    @Before
    public void init (){
        Bytes bytesV = Bytes.wrap(v);
        Bytes bytesR = Bytes.wrap(v);
        Bytes bytesS = Bytes.wrap(v);
        RLPElement rlpV = RLPElement.fromBytes(bytesV);
        RLPElement rlpR = RLPElement.fromBytes(bytesR);
        RLPElement rlpS = RLPElement.fromBytes(bytesS);

        vrs = new VRS(rlpV,rlpR,rlpS);
        Bytes toBytes = Bytes.wrap(to);
        RLPElement rlpTo = RLPElement.fromBytes(toBytes);

        transaction = new mTransaction(rlpTo,created,timeOut, vrs);
    }

    @Test
    public void should_parse_unparse(){
        Bytes bytes = transaction.toBytes();

        mTransaction trns = mTransaction.fromBytes(bytes);


        Assert.assertEquals(transaction.getCreated(),trns.getCreated() );
        Assert.assertEquals(transaction.getTimeOut(),trns.getTimeOut() );
        Assert.assertEquals(transaction.getTo(),trns.getTo() );


    }

}
