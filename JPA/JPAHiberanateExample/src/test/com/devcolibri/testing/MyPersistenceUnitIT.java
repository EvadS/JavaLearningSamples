package com.devcolibri.testing;

import com.javacodegeeks.snippets.enterprise.Phone;
import com.javacodegeeks.snippets.enterprise.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class MyPersistenceUnitIT {
    //TODO: how to connect to derby ??
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
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
    public void shouldInsert() throws Exception {

        em.getTransaction().begin();

        Phone phone1 = new Phone();
        phone1.setNumber("55555");
        phone1.setType("fixed");
        em.persist(phone1);

        Phone phone2 = new Phone();
        phone2.setNumber("111-111");
        phone2.setType("mobile");
        em.persist(phone2);

        User employee = new User();
        employee.setName("Jack");
        employee.setSurname("Thomson");
        employee.setTitle("QA Engineer");
        employee.setCreated(new Date());
        employee.addPhone(phone1);
        employee.addPhone(phone2);

        em.persist(employee);

        long employeeId = employee.getId();

        em.getTransaction().commit();

        em.getTransaction().begin();

        User dbEmployee =em.find(User.class, employeeId);
        System.out.println("dbEmployee " + dbEmployee);

        //  Query query = em.createQuery("DELETE FROM Employee e WHERE title like '%Engineer%'");
        em.getTransaction().commit();

    }
}
