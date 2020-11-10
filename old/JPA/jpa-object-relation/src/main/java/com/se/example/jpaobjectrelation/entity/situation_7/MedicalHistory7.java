package com.se.example.jpaobjectrelation.entity.situation_7;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(PersonId7.class)
public class MedicalHistory7 implements Serializable {
    @Id
    @JoinColumns({
            @JoinColumn(name="Person_firstName", referencedColumnName="firstName"),
            @JoinColumn(name="Person_lastName", referencedColumnName="lastName")
    })
    @OneToOne
    Person7 patient;
}
