package com.se.example.footballtournamentmanagment.dto;

import com.se.example.footballtournamentmanagment.entity.FileStorage;
import com.se.example.footballtournamentmanagment.entity.Team;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class TeamDTO {


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


    private MultipartFile file;

    private String fileStorageID;



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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFileStorageID() {
        return fileStorageID;
    }

    public void setFileStorageID(String fileStorageID) {
        this.fileStorageID = fileStorageID;
    }

    public static Team toEntity(TeamDTO teamdto, FileStorage fileStorage) {
        Team team = new Team();

        team.setCapitan(teamdto.capitan);
        team.setName(teamdto.name);
        team.setNickname(teamdto.Nickname);
        team.setHeadCoach(teamdto.headCoach);
        team.setFifaRating(teamdto.fifaRating);
        team.setFoundationYear(teamdto.foundationYear);
        team.setFileStorage(fileStorage);
        team.setId(teamdto.id);

        return team;
    }

    public static TeamDTO toDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.capitan= team.getCapitan();
        teamDTO.fifaRating = team.getFifaRating();
        teamDTO.foundationYear = team.getFoundationYear();

        teamDTO.headCoach = team.getHeadCoach();
        teamDTO.name = team.getName();
        teamDTO.Nickname = team.getNickname();
        teamDTO.id = team.getId();

        return  teamDTO;
    }

    public static Team updateEntity(Team team, TeamDTO teamDTO) {
        team.setCapitan(teamDTO.capitan);
        team.setName(teamDTO.name);
        team.setNickname(teamDTO.Nickname);
        team.setHeadCoach(teamDTO.headCoach);
        team.setFifaRating(teamDTO.fifaRating);
        team.setFoundationYear(teamDTO.foundationYear);

        return team;
    }
}
