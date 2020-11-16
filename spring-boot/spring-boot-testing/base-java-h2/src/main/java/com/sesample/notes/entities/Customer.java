package com.sesample.notes.entities;

import javax.persistence.*;

/**
 * @author Evgeniy Skiba on 14.11.2020
 * @project base-java-h2
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final String email;

    public Customer() {
        this(null,null);
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Other code omitted
}