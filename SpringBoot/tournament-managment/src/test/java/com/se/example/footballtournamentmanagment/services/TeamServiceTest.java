package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

public class TeamServiceTest {


    @Autowired
    private TeamService teamService;

    @MockBean
    TeamRepository teamRepository;


    @TestConfiguration
    static class TeamServiceImpTest {
        @Bean
        public TeamService teamService() {
            return new TeamServiceImpl();
        }
    }


}
