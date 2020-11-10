package com.se.example.footballtournamentmanagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int foundationYear;

    private String Nickname;

    @NotNull
    private String headCoach;

    @NotNull
    private int fifaRating;

    @NotNull
    private String capitan;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "team_TourmanentGroup",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "tourmanentGroup_id")})

    private Set<TourmanentGroup> tourmanentGroups = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fileStorage_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private FileStorage fileStorage;

    public Team() {
    }

    public Team(@NotNull String name, int foundationYear, String nickname, String headCoach, int fifaRating, String capitan, Set<TourmanentGroup> tourmanentGroups) {
        this.name = name;
        this.foundationYear = foundationYear;
        Nickname = nickname;
        this.headCoach = headCoach;
        this.fifaRating = fifaRating;
        this.capitan = capitan;
        this.tourmanentGroups = tourmanentGroups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(int foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }

    public int getFifaRating() {
        return fifaRating;
    }

    public void setFifaRating(int fifaRating) {
       this.fifaRating = fifaRating;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public Set<TourmanentGroup> getTourmanentGroups() {
        return tourmanentGroups;
    }

    public void setTourmanentGroups(Set<TourmanentGroup> tourmanentGroups) {
        this.tourmanentGroups = tourmanentGroups;
    }

    public FileStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }
}
