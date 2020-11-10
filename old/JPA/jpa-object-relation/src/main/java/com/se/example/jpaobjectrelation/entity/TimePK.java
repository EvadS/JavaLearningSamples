package com.se.example.jpaobjectrelation.entity;

import java.io.Serializable;

/**
 * class for the composite primary key
 */
public class TimePK implements Serializable {
    protected Integer levelStation;
    protected Integer confPathID;

    public TimePK() {}

    public TimePK(Integer levelStation, Integer confPathID) {
        this.levelStation = levelStation;
        this.confPathID = confPathID;
    }
    // equals, hashCode
}