package com.se.example.jpaobjectrelation.entity.situation_9;


import javax.persistence.*;

@Entity
@IdClass(DependentId9.class)
public class Dependent9 {
    @Id
    String name;
    @Id
    @JoinColumns({
            @JoinColumn(name="Employee_firstName", referencedColumnName="firstName"),
            @JoinColumn(name="Employee_lastName", referencedColumnName="lastName")
    })
    @ManyToOne
    Employee9 employee9;
}
