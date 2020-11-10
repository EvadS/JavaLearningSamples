package com.devcolibri.testing;

import com.eclipselink.apachederby.entity.Players;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TurnamentsPlayersIT {

    //TODO: how to connect to derby ??
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");
    private EntityManager em;
    private EntityTransaction tx;
    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if (em != null) em.close();
    }

    @Test
    public void shouldBeManyToMany(){
        List players  = em.createQuery("SELECT e FROM Players e").getResultList();
        assertEquals(players,players.size());
    }

    @Test
    public void shouldInsert(){


        com.eclipselink.apachederby.entity.Players player = new com.eclipselink.apachederby.entity.Players();
        player.setAge(20);
        player.setName("New_Name");
        player.setSurname("New_Surname");
        player.setBirth(new Date());

        com.eclipselink.apachederby.entity.Players player2 = new com.eclipselink.apachederby.entity.Players();
        player2.setAge(20);
        player2.setName("New_Name");
        player2.setSurname("New_Surname");
        player2.setBirth(new Date());

        com.eclipselink.apachederby.entity.Tournaments tournaments = new   com.eclipselink.apachederby.entity.Tournaments();
        tournaments.setTournament("Tournament name ");

        Collection playersCollection = new ArrayList<Players>() ;
        playersCollection.add(player);
        playersCollection.add(player2);

        tournaments.setPlayers(playersCollection);

        // Persists   to the database
        tx.begin();
        em.persist(player);
        em.persist(player2);

        em.persist(tournaments);

        tx.commit();
        assertNotNull("ID should not be null", player.getId());

        assertNotNull("ID should not be null", player2.getId());

        assertNotNull("ID should not be null", tournaments.getId());
    }


}
