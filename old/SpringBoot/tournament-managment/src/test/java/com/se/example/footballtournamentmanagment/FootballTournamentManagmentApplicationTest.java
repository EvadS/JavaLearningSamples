package com.se.example.footballtournamentmanagment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = {FootballTournamentManagmentApplication.class})
public class FootballTournamentManagmentApplicationTest {

    @Test
    public void contextLoads() {
    }

}
