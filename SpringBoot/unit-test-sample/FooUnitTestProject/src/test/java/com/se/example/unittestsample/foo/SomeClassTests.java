package com.se.example.unittestsample.foo;

import com.se.example.unittestsample.components.SomeClass;
import com.se.example.unittestsample.components.SomeDependency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SomeClassTestsConfig.class)
public class SomeClassTests {

    @Autowired
    private SomeClass someClass;

    @Autowired
    private SomeDependency someDependency;

    @Before
    public void setup() {
        Mockito.reset(someDependency);
    }
        @Test
        public void someTest() {

        int a =10;
        }
    }