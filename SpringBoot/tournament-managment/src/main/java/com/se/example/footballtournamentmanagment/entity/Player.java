package com.se.example.footballtournamentmanagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @NotNull
    private String mName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "footballPosition_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PlayerAmplua playerAmplua;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fileStorage_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private FileStorage fileStorage;


    public Player() {
    }

    /**
     *
     * @param fName
     * @param lName
     * @param mName
     * @param birthDate
     * @param playerAmplua
     */
    public Player(@NotNull String fName, @NotNull String lName, @NotNull String mName, Date birthDate, PlayerAmplua playerAmplua) {
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
        this.birthDate = birthDate;
        this.playerAmplua = playerAmplua;

    }

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PlayerAmplua getPlayerAmplua() {
        return playerAmplua;
    }

    public void setPlayerAmplua(PlayerAmplua playerAmplua) {
        this.playerAmplua = playerAmplua;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileStorage getFileStorage() {
        return fileStorage;
    }

    public void setFileStorage(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }
}
