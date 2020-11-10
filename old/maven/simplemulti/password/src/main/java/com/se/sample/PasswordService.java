package com.se.sample;

public interface PasswordService {

    String hash(String input);

    String algorithm();

}