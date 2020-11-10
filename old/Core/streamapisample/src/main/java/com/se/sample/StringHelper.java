package com.se.sample;

import java.util.Base64;

public class StringHelper {
    public static void toBase64AndBack(){
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        int a =10;
    }
}
