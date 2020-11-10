package com.se.example.blogposts.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="user")
@NamedQueries({
        @NamedQuery(
                name = "findUserById",
                query = "from User u where u.id = :id"
        ),
        @NamedQuery(
                name = "findUsersByAccountId",
                query = "from User u where u.account.id = :id"
        ),
})
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "email_address") private String emailAddress;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "created_by") private int createdBy;
    @Column(name = "created_on") private Timestamp createdOn;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id") private Account account;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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