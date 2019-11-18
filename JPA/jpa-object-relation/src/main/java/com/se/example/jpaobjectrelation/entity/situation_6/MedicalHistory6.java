package com.se.example.jpaobjectrelation.entity.situation_6;

import javax.persistence.*;

@Entity
public class MedicalHistory6 {
    //all attributes map to relationship: AttributeOverride not allowed
    @EmbeddedId
    PersonId6 id;
    @MapsId
    @JoinColumns({
            @JoinColumn(name="Person_firstName", referencedColumnName="firstName"),
            @JoinColumn(name="Person_lastName", referencedColumnName="lastName")
    })
    @OneToOne
    Person6 patient;
}
