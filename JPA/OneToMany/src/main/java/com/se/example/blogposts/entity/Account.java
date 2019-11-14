package com.se.example.blogposts.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="account")
@NamedQueries({
        @NamedQuery(
                name = "findAccountById",
                query = "from Account a where a.id = :id"
        ),
})
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "code") private String code;
    @Column(name = "created_by") private int createdBy;
    @Column(name = "created_on") private Timestamp createdOn;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    public Timestamp getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}