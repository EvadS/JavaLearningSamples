package com.se.example.footballtournamentmanagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.example.footballtournamentmanagment.entity.enums.GoalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long gooalTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "matchItem_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MatchItem matchItem;

    @Enumerated(EnumType.STRING)
    private GoalType goalType;

    public Score() {
    }

    public Score(Long gooalTime, Player player, MatchItem matchItem, GoalType goalType) {
        this.gooalTime = gooalTime;
        this.player = player;
        this.matchItem = matchItem;
        this.goalType = goalType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGooalTime() {
        return gooalTime;
    }

    public void setGooalTime(Long gooalTime) {
        this.gooalTime = gooalTime;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MatchItem getMatchItem() {
        return matchItem;
    }

    public void setMatchItem(MatchItem matchItem) {
        this.matchItem = matchItem;
    }

    public GoalType getGoalType() {
        return goalType;
    }

    public void setGoalType(GoalType goalType) {
        this.goalType = goalType;
    }
}
