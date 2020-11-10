package com.devcolibri.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "atp_players")
@NamedQueries({
        @NamedQuery(
                name = "Player.findAllUnordered",
                query = "SELECT p FROM Player p"),
        @NamedQuery(
                name = "Player.findAllOrderedByName",
                query = "SELECT p FROM Player p ORDER BY p.name"),
        @NamedQuery(
                name = "Player.findByAge",
                query = "SELECT p FROM Player p WHERE p.age = :age"),
        @NamedQuery(
                name = "Player.findBetweenAge",
                query = "SELECT p FROM Player p WHERE p.age BETWEEN ?1 AND ?2")
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Player.countAllwithSQL",
                query = "SELECT COUNT(*) AS total FROM atp_players"),
        @NamedNativeQuery(
                name = "Player.findAllUnorderedWihSQL",
                query = "SELECT * FROM atp_players",
                resultClass = Player.class)
})
public class Player implements Serializable {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
