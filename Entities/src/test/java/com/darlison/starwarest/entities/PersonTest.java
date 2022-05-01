package com.darlison.starwarest.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;


public class PersonTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Person people = new Person(
            1L,
            "Luke Skywalker",
            "19BBY",
            "blue",
            "male",
            "blond",
            "172",
            "77",
            "fair",
            new Planet(1L),
            List.of(new Film(1L)),
            Collections.emptyList(),
            List.of(new Vehicle(24L), new Vehicle(30L)),
            List.of(new Starship(12L)),
            dateFormatter.parse("2014-12-09T13:50:51"),
            dateFormatter.parse("2014-12-20T21:17:56"),
            "https://swapi.dev/api/people/1/"
        );
        assertSame(1L, people.getId());
        assertSame("Luke Skywalker", people.getName());
        assertSame("19BBY", people.getBirthYear());
        assertSame("blue", people.getEyeColor());
        assertSame("male", people.getGender());
        assertSame("blond", people.getHairColor());
        assertSame("172", people.getHeight());
        assertSame("77", people.getMass());
        assertSame("fair", people.getSkinColor());
        assertSame(new Planet(1L).getId(), people.getHomeworld().getId());
        Assertions.assertEquals(List.of(new Film(1L)), people.getFilms());
        Assertions.assertEquals(Collections.emptyList(), people.getSpecies());
        Assertions.assertEquals(List.of(new Vehicle(24L), new Vehicle(30L)), people.getVehicles());
        Assertions.assertEquals(List.of(new Starship(12L)), people.getStarships());
        Assertions.assertEquals(dateFormatter.parse("2014-12-09T13:50:51"), people.getCreated());
        Assertions.assertEquals(dateFormatter.parse("2014-12-20T21:17:56"), people.getEdited());
        assertSame("https://swapi.dev/api/people/1/", people.getUrl());
    }

}
