package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.dto.TeamDTO;
import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Future;

public interface TeamService {
    TeamDTO create(TeamDTO team);
    TeamDTO update(TeamDTO team) throws IOException;

    TeamDTO addPlayer(Long teamId, Long playerId);
    TeamDTO addPlayers(Long teamId,List<Player> player);

    TeamDTO removeFromTeam(Long teamId, Long playerId);


    List<Player> playersByTeam(Long teamId);
    Boolean playersWasLeave(Long PlayerId);

    Future<Page<Team>> find(int currentPage, int pageSize, Sort sort);
    Path updatePhoto(Long teamID, MultipartFile file);
}
