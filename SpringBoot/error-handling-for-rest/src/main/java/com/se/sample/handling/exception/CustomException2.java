package com.se.sample.handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class CustomException2  extends RuntimeException  {

    public CustomException2() {
        super("CustomException2");
    }
}
