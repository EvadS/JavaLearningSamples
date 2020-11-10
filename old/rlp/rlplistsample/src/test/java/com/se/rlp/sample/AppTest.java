package com.se.rlp.sample;


import net.consensys.cava.bytes.Bytes;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final byte[] TRANSACTION_HASH = "TRANSACTION_HASH".getBytes(StandardCharsets.UTF_8);

    @Test
    public void should_create_transaction_hash() {

        Bytes hashBytes = Bytes.wrap(TRANSACTION_HASH);
        TransactionHash transHash = new TransactionHash(hashBytes);

        Bytes innerBytes = transHash.getBytes();
        TransactionHash destTransHash = TransactionHash.fromBytes(innerBytes);

        Assert.assertEquals(transHash, destTransHash);
    }

    @Test
    public void should_parse_unparse() {
        TransactionHash transactionHash = new TransactionHash(Bytes.wrap("1".getBytes(StandardCharsets.UTF_8)));
        TransactionHash transactionHash2 = new TransactionHash(Bytes.wrap("2".getBytes(StandardCharsets.UTF_8)));
        TransactionHash transactionHash3 = new TransactionHash(Bytes.wrap("3".getBytes(StandardCharsets.UTF_8)));
        TransactionHash transactionHash4 = new TransactionHash(Bytes.wrap("4".getBytes(StandardCharsets.UTF_8)));

        List<TransactionHash> transactionHashList = Arrays.asList(
                transactionHash, transactionHash2, transactionHash3, transactionHash4);

        Block block = new Block(1, transactionHashList);

        Bytes blockBytes = block.getBytes();
        Block destBlock = Block.fromBytes(blockBytes);

        Assert.assertEquals(block.getNumber() , destBlock.getNumber());
        Assert.assertEquals(block.getTransHashList().size(), destBlock.getTransHashList().size());
        Assert.assertEquals(block.getTransHashList().get(0), destBlock.getTransHashList().get(0));

        Assert.assertEquals(block , destBlock);

    }
}
