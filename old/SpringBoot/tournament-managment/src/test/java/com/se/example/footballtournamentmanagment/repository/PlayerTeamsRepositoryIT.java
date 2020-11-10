package com.se.example.footballtournamentmanagment.repository;


import com.se.example.footballtournamentmanagment.entity.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerTeamsRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerTeamsRepository playerTeamsRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamsRepository;


    @Test
    public  void test_applicationcontext_correct(){
        Assert.assertTrue(true);
    }

    private Player createPlayer() throws ParseException {
        Player player = new Player();
        player.setmName("mName");
        player.setfName("fName");
        player.setlName("lName");


        Calendar calendarDate = Calendar.getInstance(
                TimeZone.getTimeZone("UTC"));
      //  calendarDate.set(Calendar.YEAR, 2017);
      //  calendarDate.set(Calendar.MONTH, 10);
      //  calendarDate.set(Calendar.DAY_OF_MONTH, 15);

        java.time.LocalDate localDate;

        localDate = (LocalDate.parse("2017-11-15"));


        player.setBirthDate(localDate.);
    }

    @Test
    public void when_create_player_team_should_save(){

    }
}
