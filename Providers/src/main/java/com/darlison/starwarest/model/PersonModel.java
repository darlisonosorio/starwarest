package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.darlison.starwarest.util.UrlHelper.extractIdFromUrl;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonModel extends BaseModel {

    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("eye_color")
    private String eyeColor;
    private String gender;

    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String mass;

    @JsonProperty("skin_color")
    private String skinColor;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;

    public PersonModel(
            String name,
            String birthYear,
            String eyeColor,
            String gender,
            String hairColor,
            String height,
            String mass,
            String skinColor,
            String homeworld,
            List<String> films,
            List<String> species,
            List<String> vehicles,
            List<String> starships,
            String created,
            String edited,
            String url
    ) {
        super(created, edited, url);
        this.name = name;
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.mass = mass;
        this.skinColor = skinColor;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.starships = starships;
        this.vehicles = vehicles;
    }

    public Person toEntity() {
        final Person result = new Person();
        result.setName(this.name);
        result.setBirthYear(this.birthYear);
        result.setEyeColor(this.eyeColor);
        result.setGender(this.gender);
        result.setHairColor(this.hairColor);
        result.setHeight(this.height);
        result.setMass(this.mass);
        result.setSkinColor(this.skinColor);
        result.setHomeworld(this.homeworld == null
                ? null
                : new Planet(extractIdFromUrl(this.homeworld))
        );
        result.setFilms(this.films.stream()
                .map(it -> new Film(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setSpecies(this.species.stream()
                .map(it -> new Specie(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setStarships(this.starships.stream()
                .map(it -> new Starship(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setVehicles(this.vehicles.stream()
                .map(it -> new Vehicle(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        this.setEntityValues(result);
        return result;
    }
}
