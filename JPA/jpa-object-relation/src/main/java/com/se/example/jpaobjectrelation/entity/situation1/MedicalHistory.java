package com.se.example.jpaobjectrelation.entity.situation1;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name ="medical_history_2")
@Table(name = "medical_history_2")
public class MedicalHistory implements Serializable {

    // default join column name is overridden
    @Id
    @OneToOne
    @JoinColumn(name="Person_ssn")
    Person2 patient;
}
