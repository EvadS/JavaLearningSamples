package com.se.example.jpaobjectrelation.entity.situation_5;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(PersonId5.class)
public class MedicalHistory5 implements Serializable {
    @Id
    @JoinColumns({
            @JoinColumn(name="Person_firstName", referencedColumnName="firstName"),
            @JoinColumn(name="Person_lastName", referencedColumnName="lastName")
    })
    @OneToOne
    Person5 patient;
}
