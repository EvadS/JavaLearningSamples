package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StadiumRepository extends PagingAndSortingRepository<PlayerAmplua, Long> {
}
