package com.se.security.demo.security;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnreadableCredentialsExceptionTest {

    @Test
    void shouldGiveCorrectMessageAndCause() {
        UnreadableCredentialsException exception = new UnreadableCredentialsException("expected", new IOException());
        assertEquals("expected", exception.getMessage());
        assertTrue(exception.getCause() instanceof IOException);
    }
}