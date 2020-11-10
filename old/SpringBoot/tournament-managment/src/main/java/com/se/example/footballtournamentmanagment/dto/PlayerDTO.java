package com.se.example.footballtournamentmanagment.dto;

import com.se.example.footballtournamentmanagment.entity.FileStorage;
import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PlayerDTO {
    private Long id;

    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @NotNull
    private String mName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private MultipartFile file;

    private String fileStorageID;

    private Long ampluaID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getAmpluaID() {
        return ampluaID;
    }

    public void setAmpluaID(Long ampluaID) {
        this.ampluaID = ampluaID;
    }

    public String getFileStorageID() {
        return fileStorageID;
    }

    public void setFileStorageID(String fileStorageID) {
        this.fileStorageID = fileStorageID;
    }

    /**
     *
     * @param playerDTO
     * @param fileStorage
     * @param amplua
     * @return
     */
    public static Player toEntity(PlayerDTO playerDTO, FileStorage fileStorage, PlayerAmplua amplua) {
        Player player = new Player();
        player.setPlayerAmplua(amplua);
        player.setlName(playerDTO.lName);
        player.setfName(playerDTO.fName);
        player.setmName(playerDTO.mName);

        player.setFileStorage(fileStorage);
        player.setBirthDate(playerDTO.birthDate);
        player.setId(playerDTO.id);

        return player;
    }

    /**
     *
     * @param playerDTO
     * @param amplua
     * @param player
     * @return
     */
    public static Player updateEntity(Player player,PlayerDTO playerDTO, PlayerAmplua amplua) {
        player.setPlayerAmplua(amplua);
        player.setlName(playerDTO.lName);
        player.setfName(playerDTO.fName);
        player.setmName(playerDTO.mName);
        player.setBirthDate(playerDTO.birthDate);
        return player;
    }

    /**
     *
     * @param player
     * @return
     */
    public static PlayerDTO toPlayerDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.ampluaID = player.getPlayerAmplua().getId();
        playerDTO.lName = player.getlName();
        playerDTO.fName = player.getfName();
        playerDTO.birthDate = player.getBirthDate();
        playerDTO.id = player.getId();
        playerDTO.mName = player.getmName();

        player.setId(playerDTO.id);

        return playerDTO;
    }
}
