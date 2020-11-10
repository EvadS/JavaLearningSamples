package com.se.example.demomodelmapper.entity;


import com.se.example.demomodelmapper.attributes.Color;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * У нас будет единорог (Unicorn), у которого в подчинении будет какое-то количество дроидов (Droid),
 * и у каждого дроида будет какое-то количество капкейков (Cupcake)
 */
@Entity
@Table(name = "unicorns")
@EqualsAndHashCode(callSuper = false)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Unicorn extends AbstractEntity {

    private String name;
    private List<Droid> droids;
    private Color color;

    public Unicorn(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "unicorn")
    public List<Droid> getDroids() {
        return droids;
    }

    @Column(name = "color")
    public Color getColor() {
        return color;
    }
}