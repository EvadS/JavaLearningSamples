package com.se.sample.manytomanydemo.entities;


import com.se.sample.manytomanydemo.entities.enums.Category;
import com.se.sample.manytomanydemo.entities.enums.Priority;
import com.se.sample.manytomanydemo.entities.enums.Rating;

import javax.persistence.*;

@Entity
public class Classes {

    @Id
    private String classes;

    @Enumerated(EnumType.ORDINAL)
    private Rating type;

    @Transient
    private Priority priority;

    @Basic
    private int priorityValue;

    private String country;

    private int numGuns;
    private int bore ;
    private int desplacement;

// это поле сохранится как varchar
    private Category category;

    @PostLoad
    void fillTransient() {
        if (priorityValue > 0) {
            this.priority = Priority.of(priorityValue);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (priority != null) {
            this.priorityValue = priority.getPriority();
        }
    }

}
