package com.se.example.jpaobjectrelation.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;


public class TimeEmbeddable implements Serializable {
    @EmbeddedId
    private TimeEmbeddable timePK;

    private String src;
}
