package com.se.example.jpaobjectrelation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(TimePK.class)
class Time implements Serializable {
    @Id
    private Integer levelStation;
    @Id
    private Integer confPathID;

    private String src;


    // getters, setters
}