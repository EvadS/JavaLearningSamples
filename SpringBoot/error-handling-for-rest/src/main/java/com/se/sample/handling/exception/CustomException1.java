package com.se.sample.handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException1  extends Exception  {

    public CustomException1() {
        super("CustomException1");
    }
}
