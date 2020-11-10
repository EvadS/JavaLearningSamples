package com.se.example.jpaobjectrelation.entity.situation_8;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person8 {
    @EmbeddedId
    PersonId8 id;
}
