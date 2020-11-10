package com.se.jpatesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({ "test" })
public class DummyTest {

    @Autowired
    private Environment env;

    @Test
    public void readProps() {
        String value = env.getProperty("prop1") + " " + env.getProperty("prop2");
        assertEquals("Hello World", value);
    }
}
