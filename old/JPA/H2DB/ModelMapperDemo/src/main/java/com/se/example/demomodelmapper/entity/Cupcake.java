package com.se.example.demomodelmapper.entity;

import javax.persistence.Entity;

import com.se.example.demomodelmapper.attributes.Filling;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cupcakes")
@Setter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Cupcake extends AbstractEntity {

    private Filling filling;
    private Droid droid;

    @Column(name = "filling")
    public Filling getFilling() {
        return filling;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "droid_id")
    public Droid getDroid() {
        return droid;
    }

    public Cupcake(Filling filling) {
        this.filling = filling;
    }
}
