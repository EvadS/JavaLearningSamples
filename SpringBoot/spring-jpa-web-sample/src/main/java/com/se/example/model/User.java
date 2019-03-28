package com.se.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 65)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 128)
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private UserProfile userProfile;

    // Hibernate requires a no-arg constructor
    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    // Getters and Setters (Omitted for brevity)
}