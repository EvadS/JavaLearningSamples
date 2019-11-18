package com.se.sample.manytomanydemo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Outcomes {

    @Id
    private String ship;
    private String battle;
    private String result;


   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "battles_id", nullable = false)
    private Battles battles;

}
