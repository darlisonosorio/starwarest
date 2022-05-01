package com.darlison.starwarest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SpecieModelTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SpecieModel species = new SpecieModel(
                "Wookie",
                "Mammal",
                "Sentient",
                "2.1",
                "400",
                "blue, green, yellow, brown, golden, red",
                "black, brown",
                "gray",
                "Shyriiwook",
                "planets/14/",
                List.of("people/13/"),
                List.of("films/1/", "films/2/"),
                "2014-12-10T16:44:31",
                "2014-12-10T16:44:31",
                "https://swapi.dev/api/species/3/"
        );
        assertSame("Wookie", species.getName());
        assertSame("Mammal", species.getClassification());
        assertSame("2.1", species.getAverageHeight());
        assertSame("400", species.getAverageLifespan());
        assertSame("blue, green, yellow, brown, golden, red", species.getEyeColors());
        assertSame("black, brown", species.getHairColors());
        assertSame("gray", species.getSkinColors());
        assertSame("Shyriiwook", species.getLanguage());
        assertSame("planets/14/", species.getHomeworld());
        Assertions.assertEquals(List.of("people/13/"), species.getPeople());
        Assertions.assertEquals("2014-12-10T16:44:31", species.getCreated());
        Assertions.assertEquals("2014-12-10T16:44:31", species.getEdited());
        Assertions.assertEquals("https://swapi.dev/api/species/3/", species.getUrl());
    }
}
