package com.se.sample.basemvcservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.sample.basemvcservice.model.audit.DateAudit;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book
        extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //not null or empty
    @NotBlank
    private String name;

    @NotBlank
    private String author;

    private int year;


    public Long getId() {
        return id;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}