package com.se.sample.springjdbc;


import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.util.List;

public interface PersonRepository {

    // Маппер, превращающий строку из таблицы БД в объект класса Person
    RowMapper<Person> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Person(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("email"));
    };

    List<Person> findAll();

    Person findOne(String id);

    Person save(Person person);

    int delete(String id);
}
