package com.se.example.jpaobjectrelation.entity.situation_9;

import javax.persistence.*;

@Entity
@IdClass(EmployeeId9.class)
public class Employee9 {
    @Id String firstName;
    @Id String lastName;
}

