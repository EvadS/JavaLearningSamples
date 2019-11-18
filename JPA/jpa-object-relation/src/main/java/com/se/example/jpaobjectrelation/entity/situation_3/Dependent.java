package com.se.example.jpaobjectrelation.entity.situation_3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(DependentId.class)
public class Dependent {
    @Id
    String name;
    // id attribute mapped by join column default
    @Id
    @ManyToOne
    Employee employee;
}
