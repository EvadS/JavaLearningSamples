package com.se.example.propertiessample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

public class TestApplication {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultProfile() {
//        PropertiesSampleApplication.main(new String[0]);
//        String output = this.outputCapture.toString();
//        assertThat(output).contains("Today is sunny day!");
    }

    @Test
    public void testRainingProfile() {
        System.setProperty("spring.profiles.active", "raining");
        PropertiesSampleApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("Today is raining day!");
    }

    @Test
    public void testRainingProfile_withDoption() {
        PropertiesSampleApplication.main(new String[]{"--spring.profiles.active=raining"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("Today is raining day!");
    }

    @After
    public void after() {
        System.clearProperty("spring.profiles.active");
    }
}
