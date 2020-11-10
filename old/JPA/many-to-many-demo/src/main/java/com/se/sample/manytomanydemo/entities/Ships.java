package com.se.sample.manytomanydemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "Ships")
public class Ships {
    @Id
    private  String name;

    private String launched;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLASSES_ID")
    private Classes classes;
}
