package com.se.sample.helpers;

import java.nio.charset.StandardCharsets;

/**
 *
 */
public class StringHelper {
    public static void testToBytes(){
        String stringToConvert = "This String is 76 characters long and will be converted to an array of bytes";
        byte[] theByteArray = stringToConvert.getBytes();

        byte[] myByte = stringToConvert.getBytes(StandardCharsets.UTF_8);
    }

    public static void testToString() {
        byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};
        String value = new String(byteArray);
    }

    /**
     *
     * @param stringToConvert
     * @return
     */
    public static  byte[] ToByteArray(String stringToConvert ){
        byte[] theByteArray = stringToConvert.getBytes();
        return theByteArray;
    }

    /**
     *
     * @param byteArray
     * @return
     */
    public static String fromBytesToString( byte[] byteArray ) {
         return  new String(byteArray);
    }
}
