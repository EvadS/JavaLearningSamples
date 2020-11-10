package com.se.example.footballtournamentmanagment.services;

import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import com.se.example.footballtournamentmanagment.entity.PlayerTeams;
import com.se.example.footballtournamentmanagment.entity.Team;
import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.repository.PlayerRepository;
import com.se.example.footballtournamentmanagment.repository.TeamRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerServiceTest {
   /* @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamRepository teamRepository;


    @Autowired
    private PlayerTeamsRepository playerTeamsRepository ;


    @Autowired
    private PlayerAmpluaRepository playerAmpluaRepository;

    @MockBean
    PlayerRepository playerRepository;


    @TestConfiguration
    static class PlayerServiceIT {
        @Bean
        public PlayerService employeeService() {
            return new PlayerServiceImpl();
        }

        @Bean
        public PlayerAmpluaService apluaService() {
            return new PlayerAmpluaServiceImpl();
        }
    }*/

    @Before
    public void setUp() throws Exception {

/*
        PlayerAmplua amplua = new PlayerAmplua("winger");
        entityManager.persist(amplua);

        Team team = new Team();
        team.setCapitan("capitan name");
        team.setFifaRating(12);
        team.setHeadCoach("coach name");
        team.setName("team name");
        team.setNickname("nick name");

        entityManager.persist(team);
        entityManager.flush();

        Player player1 = new Player();
        player1.setfName("firsrName");
        player1.setlName("lName");
        player1.setmName("mName");

        Player player2 = new Player();
        player2.setfName("firsrName 2");
        player2.setlName("lName 2");
        player2.setmName("mName 2");

        PlayerTeams playerTeams = new PlayerTeams();
        playerTeams.setTeam(team);
        playerTeams.setPlayer(player1);

        PlayerTeams playerTeams2 = new PlayerTeams();
        playerTeams2.setTeam(team);
        playerTeams2.setPlayer(player2);


        entityManager.persist(player1);
        entityManager.flush();

        entityManager.persist(player2);
        entityManager.flush();

        entityManager.persist(playerTeams);
        entityManager.flush();

        entityManager.persist(playerTeams2);
        entityManager.flush();*/
    }


    @Test
    public void whenfindByTeam_thenPlayersListShouldBeFound() {


      /// List<Player> found = playerService.getPlayersByTeam(1L);

      //  Assert.assertEquals(found.getPositionName(),name);
    }


}