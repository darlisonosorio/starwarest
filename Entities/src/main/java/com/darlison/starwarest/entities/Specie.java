package com.darlison.starwarest.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Specie extends BaseEntity {

    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String averageLifespan;
    private String eyeColors;
    private String hairColors;
    private String skinColors;
    private String language;
    private Planet homeworld;

    private List<Person> people;
    private List<Film> films;

    public Specie(Long id) {
        super(id);
    }

    public Specie(
            Long id,
            String name,
            String classification,
            String designation,
            String averageHeight,
            String averageLifespan,
            String eyeColors,
            String hairColors,
            String skinColors,
            String language,
            Planet homeworld,
            List<Person> people,
            List<Film> films,
            Date created,
            Date edited,
            String url
    ) {
        super(id, created, edited, url);
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.averageLifespan = averageLifespan;
        this.eyeColors = eyeColors;
        this.hairColors = hairColors;
        this.skinColors = skinColors;
        this.language = language;
        this.homeworld = homeworld;
        this.people = people;
        this.films = films;
    }

}
