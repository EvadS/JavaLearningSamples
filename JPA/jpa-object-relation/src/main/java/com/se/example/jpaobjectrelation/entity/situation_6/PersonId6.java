package com.se.example.jpaobjectrelation.entity.situation_6;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonId6 implements Serializable {
    String firstName;
    String lastName;
}