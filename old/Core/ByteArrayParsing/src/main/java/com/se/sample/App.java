package com.se.sample;

import com.se.sample.helpers.StreamHelper;
import com.se.sample.helpers.StringHelper;

import java.io.*;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Student stu = createStudent();
        System.out.println("Name: " + stu.getName());
        System.out.println("Age: " + stu.getAge());

        // Convert the object to stream
        byte[] stream = StreamHelper.toStream(stu);

        // Print the array
        System.out.println(Arrays.toString(stream));

        // Print the array
        System.out.println(Arrays.toString(stream));

        Student convertedStu = StreamHelper.toStudent(stream);
        System.out.println("Name: " + convertedStu.getName());
        System.out.println("Age: " + convertedStu.getAge());
    }

    /**
     * Create a sample Student object.
     *
     * @return a Student object.
     */
    public static Student createStudent() {
        // Create a Student object
        Student stu = new Student();
        stu.setName("Alice");
        stu.setAge(24);

        stu.setSomeByteInfo(StringHelper.ToByteArray("Some info"));
        return stu;
    }

    /**
     * Save a student into a file using Serialization.
     *
     * @param stu
     *            the Student to save.
     * @param fileName
     *            the location to save.
     */
    public static void save(Student stu, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(stu);
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            e.printStackTrace();
        } catch (IOException e) {
            // Error in converting the Student
            e.printStackTrace();
        }
    }

    /**
     * Reading Student object from the given file.
     *
     * @param fileName
     *            location of the file.
     * @return converted Student object.
     */
    public static Student read(String fileName) {
        Student stu = null;
        try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
            stu = (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            e.printStackTrace();
        } catch (IOException e) {
            // Error in converting the Student
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // You are converting an invalid stream to Student
            e.printStackTrace();
        }
        return stu;
    }
}
