package com.se.security.demo.cookie;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CookieControllerTest {

    private CookieController controller;

    @Mock
    private RandomCookieJar cookieJar;

    @Before
    void setUp() {
        controller = new CookieController(cookieJar);
    }

    @Test
    void shouldGetCookies() {
        List<Cookie> expected = Arrays.asList(new Cookie("chocolate"), new Cookie("vanilla"));
        when(cookieJar.getCookies())
                .thenReturn(expected);

        List<Cookie> actual = controller.getCookies();

        assertEquals(expected, actual);
    }
}