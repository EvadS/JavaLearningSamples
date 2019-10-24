package com.se.sample.comparator.students;

import com.se.sample.comparator.StringComparator;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StudentTest {

    List<Student> studentList;
    Student student1 = new Student(1, "Иванов", "Иван", "Иваныч", LocalDate.of(1970, 10, 10), "РП-103", Arrays.asList(4, 5, 3, 5, 4), 2000);
    Student student2 = new Student(2, "Петров", "Иван", "Иваныч", LocalDate.of(1971, 11, 1), "РП-103", Arrays.asList(4, 5, 3, 5, 4), 2000);
    Student student3 = new Student(3, "Сидоров", "Иван", "Иваныч", LocalDate.of(1989, 1, 10), "РП-103", Arrays.asList(4, 5, 3, 5, 4), 2001);

    Student student4 = new Student(4, "Хочалава", "Давид", "Иваныч", LocalDate.of(1989, 1, 10), "РП-103", Arrays.asList(4, 5, 3, 5, 4), 2001);

    Student student5 = new Student(5, "Девич", "Марко", "Иваныч", LocalDate.of(1989, 1, 10), "РП-103", Arrays.asList(4, 5, 3, 5, 4), 2001);

    @Before
    public void init() {
        studentList = Arrays.asList(student1, student2, student3,student4,student5);
    }

    @Test
    public void should_sorted() {
        System.out.println("sort by f/l/m names");
        Comparator<Student> pcomp = new StudentFNameComparator()
                .thenComparing(new StudentLNameComparator())
                .thenComparing(new StudentMNameComparator());
        studentList.sort(pcomp);

        for (Student item : studentList) {
            System.out.println(item);
        }
    }


    @Test
    public void should_default_sorted() {

        System.out.println("sort by default comparator  L/M/F");
        Collections.sort(studentList);

        for (Student item : studentList) {
            System.out.println(item);
        }
    }

    @Test
    public void should_correct_sort(){
        IntStream.rangeClosed(10,100);
        List<Student> result =  studentList.stream()
                .sorted(Comparator.comparing(Student::getfName))
                .collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    }


}