package com.se.example.jpaobjectrelation.entity.situation_3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    long id;
    String empName;
}
