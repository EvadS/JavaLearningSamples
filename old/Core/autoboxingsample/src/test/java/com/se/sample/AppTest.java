package com.se.sample;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void testIntegers_should_Be_equals(){
        Integer int1 = 20;
        Integer int2 = 20;

        if(int1.equals(int2)){
            System.out.println("==");
        }
        else{
            System.out.println("!=");
        }

    }

    @Test
    public  void test_equals(){

        char a = 'a';

    }
}
