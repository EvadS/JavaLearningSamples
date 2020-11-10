package com.se.rlp.sample;

import net.consensys.cava.bytes.Bytes;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Block {

    private  int number;
    private List<TransactionHash> transHashList;

    public Block(int number, List<TransactionHash> transHash) {
        this.number = number;
        this.transHashList = transHash;
    }

    public static Block fromBytes(Bytes encoded) {
        requireNonNull(encoded);
        return RLP.decode(encoded, Block::readFrom);
    }

    public static Block readFrom(final RLPReader reader) {

        System.out.println("read from ");
        int curNum = reader.readInt();


//        final List<TransactionHash> topics = in.readList(topicsReader ->
//                Bytes.wrap(topicsReader.readValue()));
//
        List<TransactionHash> ommers = new ArrayList<>();

    reader.readList((listReader, l) -> {

         /////   Bytes bytes1 = listReader.readValue();
        //////  Bytes bytes2 = listReader.readValue();
         /////   Bytes bytes3 = listReader.readValue();

            while (!listReader.isComplete()) {
            int aa = 10;



               Bytes bytes = listReader.readValue();
                System.out.println("read: " +  bytes);
               TransactionHash transHash = TransactionHash.fromBytes(bytes);
             ////   ommers.add(transHash);
           /// ommers.add(listReader.readValue(TransactionHash::readFrom));
             //  ommers.add(listReader.readList(TransactionHash::/));
                ommers.add(transHash);

           }
        });




        return new Block(curNum,ommers);
    }


    public Bytes getBytes() {
        return RLP.encode(this::writeTo);
    }

    private void writeTo(RLPWriter rlpWriter) {
        rlpWriter.writeInt(number);

        rlpWriter.writeList(topicsWriter -> {
            System.out.println("topicsWriter");
            for (TransactionHash  transHash : transHashList) {
                System.out.printf(transHash.toString());
                topicsWriter.writeValue(transHash.getBytes());
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return number == block.number &&
                Objects.equals(transHashList, block.transHashList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, transHashList);
    }

    public int getNumber() {
        return number;
    }

    public List<TransactionHash> getTransHashList() {
        return transHashList;
    }
}
