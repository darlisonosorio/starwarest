package com.darlison.starwarest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class PersonModelTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        PersonModel people = new PersonModel(
            "Luke Skywalker",
            "19BBY",
            "blue",
            "male",
            "blond",
            "172",
            "77",
            "fair",
            "planets/1",
            List.of("films/1"),
            Collections.emptyList(),
            List.of("vehicles/14/", "vehicles/30/"),
            List.of("starships/12/"),
            "2014-12-09T13:50:51",
            "2014-12-20T21:17:56",
            "https://swapi.dev/api/people/1/"
        );
        assertSame("Luke Skywalker", people.getName());
        assertSame("19BBY", people.getBirthYear());
        assertSame("blue", people.getEyeColor());
        assertSame("male", people.getGender());
        assertSame("blond", people.getHairColor());
        assertSame("172", people.getHeight());
        assertSame("77", people.getMass());
        assertSame("fair", people.getSkinColor());
        assertSame("planets/1", people.getHomeworld());
        Assertions.assertEquals(List.of("films/1"), people.getFilms());
        Assertions.assertEquals(Collections.emptyList(), people.getSpecies());
        Assertions.assertEquals(List.of("vehicles/14/", "vehicles/30/"), people.getVehicles());
        Assertions.assertEquals(List.of("starships/12/"), people.getStarships());
        Assertions.assertEquals("2014-12-09T13:50:51", people.getCreated());
        Assertions.assertEquals("2014-12-20T21:17:56", people.getEdited());
        assertSame("https://swapi.dev/api/people/1/", people.getUrl());
    }

}
