package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.PlayerTeams;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerTeamsRepository extends PagingAndSortingRepository<PlayerTeams, Long> {
  //  public List<PlayerTeams> findByTeam(Long teamid);


    //public PlayerTeams findByTeamAndPlayer(Long teamId, Long playerId);

}