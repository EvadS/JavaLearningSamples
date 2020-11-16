package com.se.security.demo.security;

public class UnreadableCredentialsException extends RuntimeException {

    public UnreadableCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }
}
