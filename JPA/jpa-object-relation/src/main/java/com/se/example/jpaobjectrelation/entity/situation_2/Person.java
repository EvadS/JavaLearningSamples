package com.se.example.jpaobjectrelation.entity.situation_2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person2")
public class Person {
    @Id
    String ssn;
}
