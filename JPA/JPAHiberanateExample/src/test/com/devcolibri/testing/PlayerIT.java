package com.devcolibri.testing;

import com.devcolibri.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PlayerIT {

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
    public void existsPlayers(){
        List<Player> playersList = em.createNamedQuery("Player.countAllwithSQL", Player.class).getResultList();
        assertEquals(1, playersList.size());
        int test =0;
    }

    @Test
    public void shouldFindjavaee7Book() throws Exception {
        Player player = em.find(Player.class, 1000);
        assertEquals("player_name",player.getName());
    }


    @Test
    public void shouldCreatePlayer() throws Exception {
        Player player ;
        player = new Player();
        player.setAge(20);
        player.setName("New_Name");
        player.setSurname("New_Surname");
        player.setBirth(new Date());
        // Persists   to the database
        tx.begin();
        em.persist(player);
        tx.commit();
        assertNotNull("ID should not be null", player.getId());


        player = em.createNamedQuery("Player.findByAge", Player.class).setParameter("age", 20).getSingleResult();
        assertEquals(20, player.getAge());
        int a =10;
    }
}
