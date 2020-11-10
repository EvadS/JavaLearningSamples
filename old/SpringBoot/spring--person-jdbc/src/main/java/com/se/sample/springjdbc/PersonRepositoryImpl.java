package com.se.sample.springjdbc;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public final class PersonRepositoryImpl implements PersonRepository {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PersonRepository.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", ROW_MAPPER);
    }

    @Override
    public Person findOne(String id) {
        Person person = null;
        try {
            person = jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}, ROW_MAPPER);
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Person with id {}", id);
        }

        return person;
    }

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(UUID.randomUUID().toString());

            assert jdbcTemplate.update("insert into person values (?, ?, ?)", person.getId(), person.getName(), person.getEmail()) > 0;
        } else {
            assert jdbcTemplate.update("update person set name = ?2, email = ?3 where id = ?1", person.getId(), person.getName(), person.getEmail()) > 0;
        }

        return findOne(person.getId());
    }

    @Override
    public int delete(String id) {
        return jdbcTemplate.update("delete from person where id = ?", id);
    }
}
