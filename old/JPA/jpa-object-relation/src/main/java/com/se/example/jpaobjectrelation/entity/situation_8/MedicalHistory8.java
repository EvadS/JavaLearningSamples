package com.se.example.jpaobjectrelation.entity.situation_8;

import javax.persistence.*;

@Entity
public class MedicalHistory8 {
    //all attributes map to relationship: AttributeOverride not allowed
    @EmbeddedId
    PersonId8 id;
    @MapsId
    @JoinColumns({
            @JoinColumn(name="Person_firstName", referencedColumnName="firstName"),
            @JoinColumn(name="Person_lastName", referencedColumnName="lastName")
    })
    @OneToOne
    Person8 patient;
}
