package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
    public Player findByFName(String name);



}