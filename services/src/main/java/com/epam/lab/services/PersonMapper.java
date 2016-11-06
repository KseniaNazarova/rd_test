package com.epam.lab.services;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setCountry(resultSet.getString("country"));
        person.setCity(resultSet.getString("city"));
        person.setSkill(resultSet.getString("skill"));
        person.setName(resultSet.getString("name"));
        person.setDate(resultSet.getDate("date"));
        return person;
    }
}
