package com.darlison.starwarest.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class FilmTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Film film = new Film(
            1L,
            "A New Hope",
            4,
            "It is a period of civil war.",
            "George Lucas",
            "Gary Kurtz, Rick McCallum",
            dateFormatter.parse("1977-05-25T00:00:00"),
            List.of(new Specie(1L)),
            List.of(new Starship(2L)),
            List.of(new Person(1L)),
            List.of(new Planet(1L)),
            dateFormatter.parse("2014-12-10T14:23:31"),
            dateFormatter.parse("2014-12-12T11:24:39")
        );

        assertSame(1L, film.getId());
        assertSame("A New Hope", film.getTitle());
        assertSame(4, film.getEpisodeId());
        assertSame("It is a period of civil war.", film.getOpeningCrawl());
        assertSame("George Lucas", film.getDirector());
        assertSame("Gary Kurtz, Rick McCallum", film.getProducer());
        Assertions.assertEquals(dateFormatter.parse("1977-05-25T00:00:00"), film.getReleaseDate());
        Assertions.assertEquals(List.of(new Specie(1L)), film.getSpecies());
        Assertions.assertEquals(List.of(new Starship(2L)), film.getStarships());
        Assertions.assertEquals(List.of(new Person(1L)), film.getCharacters());
        Assertions.assertEquals(List.of(new Planet(1L)), film.getPlanets());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T14:23:31"), film.getCreated());
        Assertions.assertEquals(dateFormatter.parse("2014-12-12T11:24:39"), film.getEdited());
    }

}
