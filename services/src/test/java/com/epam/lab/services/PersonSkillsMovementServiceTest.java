package com.epam.lab.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmitrii_Valiaev on 11/3/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test-config.xml"})
public class PersonSkillsMovementServiceTest {

    @Autowired
    PersonSkillsMovementService service;

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person();
        person.setCountry("Russia");
        person.setCity("Spb");
        person.setSkill("JavaSE");
        person.setName("Dmitrii");
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date docDate = format.parse("01.01.2016");
        person.setDate(docDate);
    }

    @Test
    public void getData() throws Exception {
        List<Person> data = service.getData();
        System.out.println(data);
        assertFalse(data.isEmpty());
    }

    @Test
    public void getPerson() throws Exception {
        Person nPerson = service.getPerson("1");
        assertEquals(person, nPerson);
    }

    @Test
    public void insertPerson() throws Exception {
        int insertedRows = service.insertPerson(person);
        assertEquals(1, insertedRows);
    }

    @Test
    public void deletePerson() throws Exception {
        service.insertPerson(person);
        int deletedRows = service.deletePerson("2");
        assertEquals(1, deletedRows);
    }

    @Test
    public void updatePerson() throws Exception {
        service.insertPerson(person);
        person.setSkill(".NET");
        service.updatePerson("2", person);
        assertEquals(person, service.getPerson("2"));
    }
}