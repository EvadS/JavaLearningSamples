package com.se.example.footballtournamentmanagment.entity;

import com.se.example.footballtournamentmanagment.entity.enums.TournamentType;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    private String tournamentName;

    @NotNull
    // @DateTimeFormat(pattern = "dd.mm.yyyy")
    @ApiModelProperty(required = true, dataType = "org.joda.time.LocalDate", example = "01.01.2016")
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private Date startDate;

    @NotNull
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    private Date endDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;

    public Tournament() {
    }

    public Long getId() {
        return id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }
}
