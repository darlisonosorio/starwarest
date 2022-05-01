package com.darlison.starwarest.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SpeciesTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Specie species = new Specie(
                1L,
                "Wookie",
                "Mammal",
                "Sentient",
                "2.1",
                "400",
                "blue, green, yellow, brown, golden, red",
                "black, brown",
                "gray",
                "Shyriiwook",
                new Planet(14L),
                List.of(new Person(13L)),
                List.of(new Film(1L), new Film(2L)),
                dateFormatter.parse("2014-12-10T16:44:31"),
                dateFormatter.parse("2014-12-10T16:44:31")
        );
        assertSame("Wookie", species.getName());
        assertSame("Mammal", species.getClassification());
        assertSame("2.1", species.getAverageHeight());
        assertSame("400", species.getAverageLifespan());
        assertSame("blue, green, yellow, brown, golden, red", species.getEyeColors());
        assertSame("black, brown", species.getHairColors());
        assertSame("gray", species.getSkinColors());
        assertSame("Shyriiwook", species.getLanguage());
        assertSame(new Planet(14L).getId(), species.getHomeworld().getId());
        Assertions.assertEquals(List.of(new Person(13L)), species.getPeople());
        Assertions.assertEquals(List.of(new Film(1L), new Film(2L)), species.getFilms());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T16:44:31"), species.getCreated());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T16:44:31"), species.getEdited());
    }
}
