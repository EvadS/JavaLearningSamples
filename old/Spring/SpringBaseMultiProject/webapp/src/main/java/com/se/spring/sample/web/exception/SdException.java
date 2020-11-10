package com.se.spring.sample.web.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Webapp exceptions
 * Created by Daniil Sanin<sdi@simple-digit.ru> on 27.06.2017.
 */
public class SdException extends RuntimeException {

    public SdException() {
        super();
    }

    public SdException(String message) {
        super(message);
    }

    public SdException(String message, Throwable cause) {
        super(message, cause);
    }

    public SdException(Throwable cause) {
        super(cause);
    }

    public SdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getFullStackTrace() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        this.printStackTrace(ps);
        return baos.toString();
    }
}
