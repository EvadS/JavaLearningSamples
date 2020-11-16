package com.sesample.notes.repository;

import com.sesample.notes.controller.Customer;
import com.sesample.notes.entities.Note;
import org.assertj.core.api.EnumerableAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.*;


import static org.hamcrest.CoreMatchers.is;


/**
 * @author Evgeniy Skiba on 14.11.2020
 * @project base-java-h2
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = "spring.flyway.enabled=false")
@EnableJpaAuditing(dateTimeProviderRef = "testDateTimeProvider")
public class NoteRepositoryTest {

    @Autowired
    private NoteRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @MockBean
    DateTimeProvider dateTimeProvider;

    //    @Test
//    public void insertNewCustomer() {
//        assertThat(repository.findAll()).isEmpty();
//        Customer customer = repository.save(new Customer(-1, "T. Testing",
//                "t.testing@test123.tst"));
//        assertThat(customer.getId()).isGreaterThan(-1L);
//        assertThat(customer.getName()).isEqualTo("T. Testing");
//        assertThat(customer.getEmail()).isEqualTo("t.testing@test123.tst");
//        assertThat(repository.findById(customer.getId())).isEqualTo(customer);
//    }


    @Test
    public void whenAssertingEquality_thenEqual() {
        String expected = "Baeldung";
        String actual = "Baeldung";

        assertEquals(expected, actual);
    }

    @Test
    public void findAllCustomers() {

        List<Note> list = repository.findAll();

        assertThat(list, empty());
         repository.save(new Note( "T. Testing1", "t.testing@test123.tst"));
        repository.save(new Note("T. Testing2", "t.testing@test123.tst"));
        assertThat(repository.findAll(), hasSize(2));
    }


}