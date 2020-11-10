package com.se.example.footballtournamentmanagment.repository;
import com.se.example.footballtournamentmanagment.entity.Team;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {

   // @Query("SELECT DISTINCT e.positionName FROM Teams e")
   // List<String> findAllDepartments(Sort sort);
}