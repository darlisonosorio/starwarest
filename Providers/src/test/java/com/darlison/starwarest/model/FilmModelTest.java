package com.darlison.starwarest.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class FilmModelTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        FilmModel film = new FilmModel(
            "A New Hope",
            4,
            "It is a period of civil war.",
            "George Lucas",
            "Gary Kurtz, Rick McCallum",
            "1977-05-25T00:00:00",
            List.of("/species/1/"),
            List.of("starships/2/"),
            List.of("people/1/"),
            List.of("planets/1/"),
            "2014-12-10T14:23:31",
            "2014-12-12T11:24:39",
            "https://swapi.dev/api/films/1/"
        );

        assertSame("A New Hope", film.getTitle());
        assertSame(4, film.getEpisodeId());
        assertSame("It is a period of civil war.", film.getOpeningCrawl());
        assertSame("George Lucas", film.getDirector());
        assertSame("Gary Kurtz, Rick McCallum", film.getProducer());
        Assertions.assertEquals("1977-05-25T00:00:00", film.getReleaseDate());
        Assertions.assertEquals(List.of("/species/1/"), film.getSpecies());
        Assertions.assertEquals(List.of("starships/2/"), film.getStarships());
        Assertions.assertEquals(List.of("people/1/"), film.getCharacters());
        Assertions.assertEquals(List.of("planets/1/"), film.getPlanets());
        Assertions.assertEquals("2014-12-10T14:23:31", film.getCreated());
        Assertions.assertEquals("2014-12-12T11:24:39", film.getEdited());
        assertSame("https://swapi.dev/api/films/1/", film.getUrl());
    }

}
