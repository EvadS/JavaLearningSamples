package com.se.sample;

import static org.junit.Assert.assertTrue;

import com.se.sample.helpers.StreamHelper;
import com.se.sample.helpers.StringHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class StudentTest
{
    /**
     * Rigorous Test :-)
     */

    private String someString = "Some String";

    // BNefore

    private  Student createStudent() {
        // Create a Student object
        byte [] bytesArr = StringHelper.ToByteArray(someString);
        Student stu = new Student("Alice",29,bytesArr);
        return stu;
    }

    @Test
    public void shouldDesiarialized(){
        Student stu = createStudent();
        // Convert the object to stream
        byte[] stream = StreamHelper.toStream(stu);

        Student convertedStu = StreamHelper.toStudent(stream);
        Assert.assertNotNull(stu);

        byte [] bytesSomeVal = stu.getSomeByteInfo();
        Assert.assertNotNull(bytesSomeVal);

        String someStringRes = StringHelper.fromBytesToString(bytesSomeVal);

        Assert.assertEquals(stu.getName() ,convertedStu.getName() );
        Assert.assertEquals(stu.getName() ,convertedStu.getName() );
        Assert.assertEquals(someString ,someStringRes);
    }
}
