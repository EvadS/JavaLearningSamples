package com.se.example.footballtournamentmanagment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PlayerAmpluaDTO {
    private Long id;

    @NotNull
    @Size(max = 100)

    private String positionName;

    public PlayerAmpluaDTO() {
    }

    public PlayerAmpluaDTO(@NotNull @Size(max = 100) String positionName) {
        this.positionName = positionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public static PlayerAmplua toEntity(PlayerAmpluaDTO dto) {
        PlayerAmplua playerAmplua = new PlayerAmplua();
        playerAmplua.setId(dto.getId());
        playerAmplua.setPositionName(dto.getPositionName());

        return playerAmplua;
    }

    public static PlayerAmpluaDTO toDto(PlayerAmplua entity) {
        PlayerAmpluaDTO dto = new PlayerAmpluaDTO();

        entity.setId(dto.getId());
        entity.setPositionName(dto.getPositionName());

        return dto;
    }

}
