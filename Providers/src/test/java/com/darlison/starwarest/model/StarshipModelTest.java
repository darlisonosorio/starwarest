package com.darlison.starwarest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StarshipModelTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        StarshipModel starship = new StarshipModel(
            "Death Star",
            "DS-1 Orbital Battle Station",
            "Deep Space Mobile Battlestation",
            "Imperial Department of Military Research, Sienar Fleet Systems",
            "1000000000000",
            "120000",
            "342953",
            "843342",
            "n/a",
            "4.0",
            "10 MGLT",
            "1000000000000",
            "3 years",
            Collections.emptyList(),
            List.of("films/1/"),
            "2014-12-10T16:36:50",
            "2014-12-10T16:36:50",
            "https://swapi.dev/api/starships/9/"
        );
        assertSame("Death Star", starship.getName());
        assertSame("DS-1 Orbital Battle Station", starship.getModel());
        assertSame("Deep Space Mobile Battlestation", starship.getStarshipClass());
        assertSame("Imperial Department of Military Research, Sienar Fleet Systems", starship.getManufacturer());
        assertSame("1000000000000", starship.getCostInCredits());
        assertSame("120000", starship.getLength());
        assertSame("342953", starship.getCrew());
        assertSame("843342", starship.getPassengers());
        assertSame("n/a", starship.getMaxAtmospheringSpeed());
        assertSame("4.0", starship.getHyperdriveRating());
        assertSame("10 MGLT", starship.getMGLT());
        assertSame("1000000000000", starship.getCargoCapacity());
        assertSame("3 years", starship.getConsumables());
        Assertions.assertEquals(Collections.emptyList(), starship.getPilots());
        Assertions.assertEquals(List.of("films/1/"), starship.getFilms());
        Assertions.assertEquals("2014-12-10T16:36:50", starship.getCreated());
        Assertions.assertEquals("2014-12-10T16:36:50", starship.getEdited());
        assertSame("https://swapi.dev/api/starships/9/", starship.getUrl());
    }
}
