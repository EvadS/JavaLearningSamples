package com.se.example.jpaobjectrelation.entity.situation_4;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Entity
public class Dependent2  implements Serializable {
    @EmbeddedId
    DependentId2 id;
    // id attribute mapped by join column default
    @MapsId("empPK") // maps empPK attribute of embedded id
    @ManyToOne
    Employee2 employee;
}
