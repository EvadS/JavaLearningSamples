package com.se.example.unittestsample.foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {
        "some.bar.value=testValue",
})

public class FooTest {

    @Value("${some.bar.value}")
    String bar;

//    @Value("${local.server.port}")   // 6
//            int port;

    @Test
    public void testValueSetup() {
        assertEquals("testValue", bar);
    }

}