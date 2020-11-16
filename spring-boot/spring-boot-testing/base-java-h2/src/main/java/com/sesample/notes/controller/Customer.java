package com.sesample.notes.controller;

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

    Customer() {
        this(null,null);
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }


// Other code omitted
}