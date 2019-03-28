package org.agoncal.book.javaee7.chapter02;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class MusicBandIT {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04TestPU");
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

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldFindJavaEE7Book() throws Exception {
        MusicBand musicBand = em.find(MusicBand.class, 1001);
        assertEquals("Name3", musicBand.getName());
    }

    @Test
    public void shouldCreateH2G2Book() throws Exception {

        // Creates an instance of book
        MusicBand book = new MusicBand("H2G2", 2007,"The Hitchhiker's Guide to the Galaxy");

        // Persists the book to the database
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID should not be null", book.getId());

        // Retrieves all the books from the database
        List<MusicBand> books = em.createNamedQuery("findBookH2G2", MusicBand.class).getResultList();
        assertEquals(1, books.size());
        book = em.createNamedQuery("findBookH2G2", MusicBand.class).getSingleResult();
        assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {

        MusicBand musicBand = new MusicBand("H2G2", 2007,"The Hitchhiker's Guide to the Galaxy");
        em.persist(musicBand);
    }
}
