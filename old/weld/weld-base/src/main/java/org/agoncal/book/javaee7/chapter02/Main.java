package org.agoncal.book.javaee7.chapter02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  public static void testEMF(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
    EntityManager em  = emf.createEntityManager();

  }
  public static void main(String[] args) {

    Weld weld = new Weld();
    WeldContainer container = weld.initialize();


    testEMF();


    weld.shutdown();
  }
}