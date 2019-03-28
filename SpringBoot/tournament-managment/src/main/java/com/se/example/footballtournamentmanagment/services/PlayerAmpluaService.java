package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.concurrent.Future;

public interface PlayerAmpluaService {
    PlayerAmplua findByAmplua(String ampluaName);

    Page<PlayerAmplua> findall(int currentPage, int pageSize, Sort sort);
    Future<Page<PlayerAmplua>>findallAsync(int currentPage, int pageSize, Sort sort) throws InterruptedException;

    PlayerAmplua find(Long ampluaId);

    PlayerAmplua updatedAmplua(PlayerAmplua playerAmplua);

    void delete(Long ampluaId);

    PlayerAmplua create(PlayerAmplua amplua);
}
