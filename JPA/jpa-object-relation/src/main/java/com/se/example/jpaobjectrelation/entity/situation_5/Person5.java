package com.se.example.jpaobjectrelation.entity.situation_5;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(PersonId5.class)
public class Person5 implements Serializable {
    @Id
    String firstName;
    @Id String lastName;
}
