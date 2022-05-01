package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.darlison.starwarest.util.UrlHelper.extractIdFromUrl;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FilmModel extends BaseModel {

    private String title;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    private List<String> species;
    private List<String> starships;
    private List<String> characters;
    private List<String> planets;

    public FilmModel(
        String title,
        Integer episodeId,
        String openingCrawl,
        String director,
        String producer,
        String releaseDate,
        List<String> species,
        List<String> starships,
        List<String> characters,
        List<String> planets,
        String created,
        String edited,
        String url
    ) {
        super(created, edited, url);
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

    public Film toEntity() {
        final Film result = new Film();
        result.setTitle(this.title);
        result.setEpisodeId(this.episodeId);
        result.setOpeningCrawl(this.openingCrawl);
        result.setDirector(this.director);
        result.setProducer(this.producer);
        result.setSpecies(this.species.stream()
                .map(it -> new Specie(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setStarships(this.starships.stream()
                .map(it -> new Starship(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setCharacters(this.characters.stream()
                .map(it -> new Person(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setPlanets(this.planets.stream()
                .map(it -> new Planet(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        this.setEntityValues(result);
        return result;
    }

}
