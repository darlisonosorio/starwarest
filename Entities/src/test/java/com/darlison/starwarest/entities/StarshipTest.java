package com.darlison.starwarest.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class StarshipTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Starship starship = new Starship(
            1L,
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
            List.of(new Film(1L)),
            dateFormatter.parse("2014-12-10T16:36:50"),
            dateFormatter.parse("2014-12-10T16:36:50")
        );

        assertSame(1L, starship.getId());
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
        Assertions.assertEquals(List.of(new Film(1L)), starship.getFilms());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T16:36:50"), starship.getCreated());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T16:36:50"), starship.getEdited());
    }
}
