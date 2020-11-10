package com.se.sample.helpers;

import com.se.sample.Student;

import java.io.*;

public class StreamHelper {

    /**
     * Convert a Student object into stream of bytes.
     *
     * @param stu
     *            Student object.
     * @return stream of bytes
     */
    public static byte[] toStream(Student stu) {
        // Reference for stream of bytes
        byte[] stream = null;
        // ObjectOutputStream is used to convert a Java object into OutputStream
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(stu);
            stream = baos.toByteArray();
        } catch (IOException e) {
            // Error in serialization
            e.printStackTrace();
        }
        return stream;
    }

    /**
     * Convert stream of bytes to Student.
     *
     * @param stream
     *            byte array
     * @return Student object
     */
    public static Student toStudent(byte[] stream) {
        Student stu = null;

        try (ByteArrayInputStream bais = new ByteArrayInputStream(stream);
             ObjectInputStream ois = new ObjectInputStream(bais);) {
            stu = (Student) ois.readObject();
        } catch (IOException e) {
            // Error in de-serialization
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // You are converting an invalid stream to Student
            e.printStackTrace();
        }

        return stu;
    }
}
