package com.se.example.jpaobjectrelation.entity.situation_3;

import java.io.Serializable;

public class DependentId implements Serializable {
    String name; // matches name of @Id attribute
    long employee; // matches name of @Id attribute and type of Employee9 PK
}
