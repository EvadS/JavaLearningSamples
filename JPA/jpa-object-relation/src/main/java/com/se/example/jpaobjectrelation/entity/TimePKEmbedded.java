package com.se.example.jpaobjectrelation.entity;


import javax.persistence.Embeddable;
import java.io.Serializable;


public class TimePKEmbedded implements Serializable {
    protected Integer levelStation;
    protected Integer confPathID;

    public TimePKEmbedded() {}

    public TimePKEmbedded(Integer levelStation, Integer confPathID) {
        this.levelStation = levelStation;
        this.confPathID = confPathID;
    }
    // equals, hashCode
}