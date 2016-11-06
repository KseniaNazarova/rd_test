package com.epam.lab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dmitrii_Valiaev on 11/3/2016.
 */
@Component
public class PersonSkillsMovementService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getData() {

        List<Person> persons = jdbcTemplate.query("SELECT * FROM person_skills", new PersonMapper());

        return persons;
    }

    public Person getPerson(String id) {
        String query = "SELECT * FROM person_skills where id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new PersonMapper());
    }

    public int insertPerson(Person person){
        String query = "insert into person_skills(country, city, skill, name, date) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, person.getCountry());
            preparedStatement.setString(2, person.getCity());
            preparedStatement.setString(3, person.getSkill());
            preparedStatement.setString(4, person.getName());
            preparedStatement.setDate(5, new Date(person.getDate().getTime()));
        });
    }

    public int deletePerson(String id){
        String query = "delete from person_skills where id = ?";
        return jdbcTemplate.update(query, preparedStatement -> preparedStatement.setInt(1, Integer.valueOf(id)));
    }

    public int updatePerson(String id, Person person){
        String query = "update person_skills set (country, city, skill, name, date) " +
                "= (?, ?, ?, ?, ?) where id = ?";
        return jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, person.getCountry());
            preparedStatement.setString(2, person.getCity());
            preparedStatement.setString(3, person.getSkill());
            preparedStatement.setString(4, person.getName());
            preparedStatement.setDate(5, new Date(person.getDate().getTime()));
            preparedStatement.setInt(6, Integer.valueOf(id));
        });
    }
}
