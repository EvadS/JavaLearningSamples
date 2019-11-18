package com.se.sample.manytomanydemo.entities;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Battles {
    @Id
    private String name;
    private Date date;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "battles")
    private Set<Outcomes> battles;
}
