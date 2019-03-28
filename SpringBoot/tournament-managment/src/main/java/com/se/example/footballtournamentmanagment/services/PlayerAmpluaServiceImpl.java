package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.exception.ResourceNotFoundException;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class PlayerAmpluaServiceImpl implements PlayerAmpluaService {

    @Autowired
    PlayerAmpluaRepository playerAmpluaRepository;

    public Page<PlayerAmplua> findall(int currentPage, int pageSize, Sort sort) {
        Pageable sortedByName = PageRequest.of(currentPage, pageSize, sort);
        return playerAmpluaRepository.findAll(sortedByName);
    }

    @Async
    @Override
    public Future<Page<PlayerAmplua>> findallAsync(int currentPage, int pageSize, Sort sort) throws InterruptedException {

        Pageable sortedByName = PageRequest.of(currentPage, pageSize, sort);
        Page<PlayerAmplua> ampluasList = playerAmpluaRepository.findAll(sortedByName);
        Thread.sleep(1000L);
        return new AsyncResult<Page<PlayerAmplua>>(ampluasList);
    }

    public PlayerAmplua updatedAmplua(PlayerAmplua amplua) {
        PlayerAmplua currAmplua = playerAmpluaRepository.findById(amplua.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("PlayerAmplua %s", amplua.getId())));
        currAmplua.setPositionName(amplua.getPositionName());
        return playerAmpluaRepository.save(currAmplua);
    }

    public PlayerAmplua  find(Long ampluaId) {
        return playerAmpluaRepository.findById(ampluaId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("PlayerAmplua %s", ampluaId)));
    }

    public PlayerAmplua create(PlayerAmplua amplua) {
        PlayerAmplua savedAmplua =  playerAmpluaRepository.save(amplua);
        return savedAmplua;
    }

    public void delete(Long ampluaId) {
        PlayerAmplua amplua =  playerAmpluaRepository.findById(ampluaId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("PlayerAmplua %s", ampluaId)));
        playerAmpluaRepository.delete(amplua);
    }

    @Override
    public PlayerAmplua findByAmplua(String ampluaName){
        //TODO:
        return null;//playerAmpluaRepository.findByPositionName(ampluaName);
    }
}