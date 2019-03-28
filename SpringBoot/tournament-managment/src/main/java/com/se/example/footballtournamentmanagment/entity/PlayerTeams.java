package com.se.example.footballtournamentmanagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PlayerTeams")
public class PlayerTeams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Team team;

    private int number;

    private LocalDateTime startWork;
    private LocalDateTime  endWork;

    public PlayerTeams() {
    }

    /**
     *      *
     * @param team
     * @param number
     */
    public PlayerTeams(Team team, int number) {
        this.team = team;
        this.number = number;
        this.startWork =  LocalDateTime.now();;
        this.endWork =  LocalDateTime.now();;
    }

    /**
     *
     * @param team
     * @param number
     * @param startWork
     * @param endWork
     */
    public PlayerTeams(Team team, int number, LocalDateTime startWork, LocalDateTime endWork) {
        this.team = team;
        this.number = number;
        this.startWork = startWork;
        this.endWork = endWork;
    }

    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDateTime getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalDateTime startWork) {
        this.startWork = startWork;
    }

    public LocalDateTime getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalDateTime endWork) {
        this.endWork = endWork;
    }
}
