package com.se.sample.basemvcservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectFileException extends RuntimeException {

    public IncorrectFileException(String message) {
        super(message);
    }

    public IncorrectFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
