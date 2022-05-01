package com.darlison.starwarest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Film extends BaseEntity {

    private String title;
    private Integer episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;

    private List<Specie> species;
    private List<Starship> starships;
    private List<Person> characters;
    private List<Planet> planets;

    public Film(Long id) {
        super(id);
    }

    public Film(
        Long id,
        String title,
        int episodeId,
        String openingCrawl,
        String director,
        String producer,
        Date releaseDate,
        List<Specie> species,
        List<Starship> starships,
        List<Person> characters,
        List<Planet> planets,
        Date created,
        Date edited
    ) {
        super(id, created, edited);
        this.title = title;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.species = species;
        this.starships = starships;
        this.characters = characters;
        this.planets = planets;
    }

}
