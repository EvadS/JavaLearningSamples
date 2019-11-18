package com.se.example.jpaobjectrelation.entity.situation_7;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person7 {
    @EmbeddedId
    PersonId7 id;
}