package com.se.sample;
import com.se.sample.helpers.StringHelper;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;

public class Student  implements Serializable {
    private String name;
   //  transient ignore for serialize
    private/* transient*/ int age;
    private byte[] someByteInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public byte[] getSomeByteInfo() {
        return someByteInfo;
    }

    public void setSomeByteInfo(byte[] someByteInfo) {
        this.someByteInfo = someByteInfo;
    }

    public Student() {
    }

    /**
     *
     * @param name
     * @param age
     * @param someInfo
     */
    public Student(String name, int age, byte [] someInfo) {
        this.name = name;
        this.age = age;
        this.someByteInfo = someInfo;
    }

    /**
     * This method is called during serialization.
     *
     * @param oos
     */
    private void writeObject(ObjectOutputStream oos) {
        // Create a calendar object of current date
        Calendar current = Calendar.getInstance();
        // Get the current year
        int currentYear = current.get(Calendar.YEAR);
        // Calculate the birth year
        int birthYear = currentYear - age;

        try {
            // Write the default attributes first
            oos.defaultWriteObject();
            // Write the birth year
            oos.writeInt(birthYear);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}