package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerAmpluaRepository extends PagingAndSortingRepository<PlayerAmplua, Long> {
    PlayerAmplua findByPositionName(String positionName);

   // @Query(value = "select u.id, u.position_name from player_amplua u where u.position_name like %?1", nativeQuery = true)
   // List<PlayerAmplua> findByFirstnameEndsWith(String firstname);
}