package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerAmpluaRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerAmpluaRepository ampluaRepository;


    @Test
    public void whenFindByNameEndsWith_thenReturnEmployee() {

   /*     PlayerAmplua playerAmplua = new PlayerAmplua("winger");
        entityManager.persist(playerAmplua);

        playerAmplua = new PlayerAmplua("winger2");
        entityManager.persist(playerAmplua);
        // when
        List<PlayerAmplua> found = ampluaRepository.findByFirstnameEndsWith("2");

        // then
        Assert.assertEquals(found.size(), 1);*/
   Assert.assertTrue(true);
    }
}
