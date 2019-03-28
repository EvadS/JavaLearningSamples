package com.se.example.springboot_validation.сontroller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRestControllerTest {

    // system out testing
    EmployeeRestControllerTest sut;

    @Before
    public void setUp() throws Exception {
        sut = new EmployeeRestControllerTest();
    }

    @Test
    public void getAllEmployees() {
        sut.getAllEmployees();
    }
}