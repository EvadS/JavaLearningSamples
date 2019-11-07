package com.se.example.jpaobjectrelation.entity.situation_2;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The parent entity has a simple primary key and the dependent entity uses IdClass to represent a composite key
 */
@Entity
@Table(name= "medical_history_2")
public class MedicalHistory implements Serializable {
    @Id
    String id; // overriding not allowed
    // default join column name is overridden
    @MapsId
    @JoinColumn(name="Person_ssn")
    @OneToOne
    Person patient;
}