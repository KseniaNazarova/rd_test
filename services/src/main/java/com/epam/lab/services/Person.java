package com.epam.lab.services;

import java.util.Date;

public class Person {

    private String country;
    private String city;
    private String skill;
    private String name;
    private Date date;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", skill='" + skill + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }else {
            Person person = (Person) obj;
            return (person.country.equals(this.country) && person.city.equals(this.city)&& person.name.equals(this.name)&& person.skill.equals(this.skill)&& person.date.equals(this.date));
        }
    }
}
