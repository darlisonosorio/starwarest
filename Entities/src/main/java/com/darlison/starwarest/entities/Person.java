package com.darlison.starwarest.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Person extends BaseEntity {

    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String mass;
    private String skinColor;
    private Planet homeworld;

    private List<Film> films;
    private List<Specie> species;
    private List<Vehicle> vehicles;
    private List<Starship> starships;

    public Person(Long id) {
        super(id);
    }

    public Person(
            Long id,
            String name,
            String birthYear,
            String eyeColor,
            String gender,
            String hairColor,
            String height,
            String mass,
            String skinColor,
            Planet homeworld,
            List<Film> films,
            List<Specie> species,
            List<Vehicle> vehicles,
            List<Starship> starships,
            Date created,
            Date edited
    ) {
        super(id, created, edited);
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

}
