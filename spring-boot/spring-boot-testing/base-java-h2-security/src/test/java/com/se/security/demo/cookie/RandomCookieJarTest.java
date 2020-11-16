package com.se.security.demo.cookie;

import com.se.security.demo.dummydata.CustomDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomCookieJarTest {

    private RandomCookieJar cookieJar;

    @Mock
    private CustomDummy customDummy;

    @BeforeEach
    void setUp() {
        cookieJar = new RandomCookieJar(customDummy);
    }

    @Test
    void shouldGetCookies() {
        String flavour = "coconut and chocolate";
        when(customDummy.listOf(eq(10), any()))
                .thenReturn( Arrays.asList(flavour));
        List<Cookie> expected =  Arrays.asList(new Cookie(flavour));

        List<Cookie> actual = cookieJar.getCookies();

        assertEquals(expected, actual);
    }
}