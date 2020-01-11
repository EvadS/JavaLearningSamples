package com.se.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogsNotFoundException extends RuntimeException {
    public DogsNotFoundException(String message) {
        super(message);
    }

    public DogsNotFoundException(long  message) {
        super (String.format("can't find dog by id : %s ", message));
    }
}