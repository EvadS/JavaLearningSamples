package com.se.example.footballtournamentmanagment.repository;

import com.se.example.footballtournamentmanagment.entity.Player;
import com.se.example.footballtournamentmanagment.entity.PlayerAmplua;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerRepositoryIT {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerAmpluaRepository ampluaRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {

        PlayerAmplua playerAmplua = new PlayerAmplua("winger");
        entityManager.persist(playerAmplua);

        // given
        Player player2 = new Player();
        player2.setfName("firsrName2");
        player2.setlName("lName 2");
        player2.setmName("mName 2");
        player2.setPlayerAmplua(playerAmplua);

        entityManager.persist(player2);
        entityManager.flush();

        // when
        Player found = playerRepository.findByFName(player2.getfName());

        // then
        Assert.assertEquals(found.getfName(), player2.getfName());
    }



    @Before
    public void clean() {
        ampluaRepository.deleteAll();
    }
}
