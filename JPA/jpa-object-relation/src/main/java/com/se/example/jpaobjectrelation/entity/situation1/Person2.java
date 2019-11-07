package com.se.example.jpaobjectrelation.entity.situation1;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Person2")
@Table(name = "person_2")
public class Person2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String ssn;

    private String name;

    public Person2() {
    }

    public Person2(String ssn, String name) {
        this.ssn = ssn;
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person = (Person2) o;
        return ssn.equals(person.ssn) &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name);
    }
}
