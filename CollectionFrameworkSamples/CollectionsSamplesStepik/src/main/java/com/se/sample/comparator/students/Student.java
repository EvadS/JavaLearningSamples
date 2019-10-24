package com.se.sample.comparator.students;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {

    private int id;
    private String fName;
    private String lName;
    private String patronomic;
    private LocalDate BirthDate;
    private String group;
    private List<Integer> scores;
    private int startEductionYear;

    public Student(int id, String fName, String lName, String patronomic, LocalDate birthDate, String group, List<Integer> scores, int startEductionYear) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.patronomic = patronomic;
        BirthDate = birthDate;
        this.group = group;
        this.scores = scores;
        this.startEductionYear = startEductionYear;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPatronomic() {
        return patronomic;
    }

    public void setPatronomic(String patronomic) {
        this.patronomic = patronomic;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public int getStartEductionYear() {
        return startEductionYear;
    }

    public void setStartEductionYear(int startEductionYear) {
        this.startEductionYear = startEductionYear;
    }


    @Override
    public int compareTo(Student o) {

//        return Comparator.comparing(Student::getlName)
//                .thenComparing(Student::getfName)
//                .thenComparing(Student::getPatronomic)
//                .compare(this, o);


        int i = getlName().compareTo(o.getlName());
        if (i != 0) return i;

        i = getPatronomic().compareTo(o.getPatronomic());
        if (i != 0) return i;

        i = getfName().compareTo(o.getfName());
        if (i != 0) return i;

        return  i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", patronomic='" + patronomic + '\'' +
                ", BirthDate=" + BirthDate +
                ", group='" + group + '\'' +
                ", startEductionYear=" + startEductionYear +
                '}';
    }
}

