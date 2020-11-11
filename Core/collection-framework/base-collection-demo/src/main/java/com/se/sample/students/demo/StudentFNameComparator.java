package com.se.sample.students.demo;

import java.util.Comparator;

class StudentFNameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getfName().compareTo(o2.getfName());
    }
}

class StudentMNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getPatronomic().compareTo(o2.getPatronomic());

    }
}

class StudentLNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getlName().compareTo(o2.getlName());

    }
}
