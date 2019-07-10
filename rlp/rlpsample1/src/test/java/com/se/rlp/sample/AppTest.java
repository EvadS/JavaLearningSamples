package com.se.rlp.sample;

import net.consensys.cava.bytes.Bytes;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        byte[] array = " ".getBytes();

        for (byte item : array) {
            System.out.println(String.format("item : %d", item));
        }

        String str = new String(array, StandardCharsets.UTF_8);
        System.out.println("str:" + str + ".");


        Bytes bytes = Bytes.wrap(array);
        boolean res = bytes.isEmpty();//f
        boolean res2 = bytes.hasLeadingZero();//t
        boolean res3 = bytes.isZero();//f

// when 0 symbol
        array[0] = (char) 0;
        bytes = Bytes.wrap(array);
        res = bytes.isEmpty();//f
        //true
        res2 = bytes.hasLeadingZero();//t
        res3 = bytes.isZero();//t

        bytes = Bytes.EMPTY;
        res = bytes.isEmpty();//t
        //true
        res2 = bytes.hasLeadingZero();//f
        res3 = bytes.isZero();//t


        assertTrue(true);


    }

    @Test
    public  void should_coorect_work_vrs(){

    }
}
