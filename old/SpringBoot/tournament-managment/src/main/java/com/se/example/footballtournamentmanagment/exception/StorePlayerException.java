package com.se.example.footballtournamentmanagment.exception;


public class StorePlayerException extends RuntimeException {

    public StorePlayerException(String message) {
        super(message);
    }

    public StorePlayerException(String message, Throwable cause) {
        super(message, cause);
    }
}