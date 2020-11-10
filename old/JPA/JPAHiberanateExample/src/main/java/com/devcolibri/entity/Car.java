package com.devcolibri.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@NamedQuery(name = "Car.getAll", query = "SELECT c from Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 40)
    private String name;      //Название авто

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate; //дата выпуска

    @Column(name = "cost")
    private float cost;       //стоимость

    public Car(String name, Date releaseDate, float cost) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.cost = cost;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", cost=" + cost +
                '}';
    }
}
