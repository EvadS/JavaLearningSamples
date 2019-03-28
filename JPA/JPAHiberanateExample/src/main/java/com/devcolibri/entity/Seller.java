package com.devcolibri.entity;

import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sellers")
public class Seller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="seller_id", length = 6)
    private long id;

    @Column(name = "name", length = 32)
    private String fullName; // Полное имя

    @Column(name = "age")
    private int age;         // Возвраст

    @Column(name = "salary")
    private float salary;    // Зар. плата

    public Seller(String fullName, int age, float salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public Seller() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
