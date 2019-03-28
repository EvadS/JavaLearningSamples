package com.eclipselink.apachederby.entity;

// Imports
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;


@Entity
@Table(name = "atp_players2")
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_surname")
    private String surname;

    @Column(name = "player_age")
    private int age;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "player_birth")
    private Date birth;

    /**
     * CascadeType.PERSIST: It means that the save() and persist() operations in the hibernate cascade to the related entities
     * CascadeType.MERGE: It means that the related entities are joined when the owning entity is joined
     * CascadeType.REMOVE: It means that the related entities are deleted when the owning entity is deleted
     * CascadeType.DETACH: It detaches all the related entities if a manual detach occurs
     * CascadeType.REFRESH: It works similar to the refresh() operation in the hibernate
     * CascadeType.ALL: It is an alternative for performing all the above cascade operations in the hibernate framework
     */
    @ManyToMany(targetEntity = com.eclipselink.apachederby.entity.Tournaments.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection tournaments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Collection getTournaments() {
        return tournaments;
    }

    public void setTournaments(Collection tournaments) {
        this.tournaments = tournaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
