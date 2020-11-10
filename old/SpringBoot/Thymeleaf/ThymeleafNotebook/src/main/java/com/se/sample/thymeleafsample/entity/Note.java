package com.se.sample.thymeleafsample.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test", schema = "test", catalog = "")
public class Note {

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;


    @Column(name = "message")
    private String message;
    @Column(name = "date")
    private Date date;
    @Column(name = "done")
    private boolean done;

    public Note() {
    }

    public Note(String message) {
        this.message = message;
        this.date = new Date();
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}