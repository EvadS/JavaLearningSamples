package com.se.example.footballtournamentmanagment.entity;

import com.se.example.footballtournamentmanagment.repository.PlayerAmpluaRepository;
import com.se.example.footballtournamentmanagment.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerTest {
    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerAmpluaRepository playerAmpluaRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {

        PlayerAmplua amplua = new PlayerAmplua("winger");
        entityManager.persist(amplua);

        // given
        Player player = new Player();
        player.setfName("firsrName");
        player.setlName("lName");
        player.setmName("mName");
        player.setPlayerAmplua(amplua);

        entityManager.persist(player);
        entityManager.flush();

        // when
        Player found = playerRepository.findByFName(player.getfName());

        // then
        assertThat(found.getfName()).isEqualTo(player.getfName());
        assertThat(found.getlName()).isEqualTo(player.getlName());
        assertThat(found.getmName()).isEqualTo(player.getmName());
    }
}
