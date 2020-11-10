package com.se.example.jpaobjectrelation.entity.situation_6;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PersonId6.class)
public class Person6 {
    @Id
    String firstName;
    @Id String lastName;
}
