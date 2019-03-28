package com.devcolibri.entity;


import com.devcolibri.enums.DeveloperType;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated
    private DeveloperType developerType;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public DeveloperType getDeveloperType() {
        return developerType;
    }
    public void setDeveloperType(DeveloperType developerType) {
        this.developerType = developerType;
    }

    @Override
    public String toString() {
        return "Developer [developerType=" + developerType + ", id=" + id
                + ", name=" + name + "]";
    }

}