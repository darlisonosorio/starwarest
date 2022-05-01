package com.darlison.starwarest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PlanetModelTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        PlanetModel planet = new PlanetModel(
            "Tatooine",
            "10465",
            "23",
            "304",
            "1",
            "120000",
            "Arid",
            "Dessert",
            "1",
            List.of("films/1/"),
            List.of("people/1/"),
            "2014-12-09T13:50:49",
            "2014-12-15T13:48:16",
            "https://swapi.dev/api/planets/1/"
        );
        assertSame("Tatooine", planet.getName());
        assertSame("10465", planet.getDiameter());
        assertSame("23", planet.getRotationPeriod());
        assertSame("304", planet.getOrbitalPeriod());
        assertSame("1", planet.getGravity());
        assertSame("120000", planet.getPopulation());
        assertSame("Arid", planet.getClimate());
        assertSame("Dessert", planet.getTerrain());
        assertSame("1", planet.getSurfaceWater());
        Assertions.assertEquals(List.of("films/1/"), planet.getFilms());
        Assertions.assertEquals(List.of("people/1/"), planet.getResidents());
        Assertions.assertEquals("2014-12-09T13:50:49", planet.getCreated());
        Assertions.assertEquals("2014-12-15T13:48:16", planet.getEdited());
        assertSame("https://swapi.dev/api/planets/1/", planet.getUrl());
    }
}
