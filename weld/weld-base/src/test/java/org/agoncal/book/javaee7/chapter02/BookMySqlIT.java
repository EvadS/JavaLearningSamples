package org.agoncal.book.javaee7.chapter02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;

public class BookMySqlIT {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-eclipselink");
    private EntityManager em;
    private EntityTransaction tx;
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
    public void shouldFindjavaee7Book() throws Exception {
        // TODO: разобраться с persistance.xml
        Book book = em.find(Book.class, 2000L);
        assertEquals("Beginning Java EE 6", book.getTitle());
    }

}
