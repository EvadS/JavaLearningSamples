package com.se.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DogsServiceException extends RuntimeException {
    public DogsServiceException(String message) {
        super(message);
    }
}