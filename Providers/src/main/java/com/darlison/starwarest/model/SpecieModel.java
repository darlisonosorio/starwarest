package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.entities.Specie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.darlison.starwarest.util.UrlHelper.extractIdFromUrl;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SpecieModel extends BaseModel {

    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String averageLifespan;
    private String eyeColors;
    private String hairColors;
    private String skinColors;
    private String language;
    private String homeworld;

    private List<String> people;
    private List<String> films;

    public SpecieModel(
            String name,
            String classification,
            String designation,
            String averageHeight,
            String averageLifespan,
            String eyeColors,
            String hairColors,
            String skinColors,
            String language,
            String homeworld,
            List<String> people,
            List<String> films,
            String created,
            String edited,
            String url
    ) {
        super(created, edited, url);
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

    public Specie toEntity() {
        final Specie result = new Specie();
        result.setName(name);
        result.setClassification(classification);
        result.setDesignation(designation);
        result.setAverageHeight(averageHeight);
        result.setAverageLifespan(averageLifespan);
        result.setEyeColors(eyeColors);
        result.setHairColors(hairColors);
        result.setSkinColors(skinColors);
        result.setLanguage(language);
        result.setHomeworld(this.homeworld == null
            ? null
            : new Planet(extractIdFromUrl(this.homeworld))
        );
        result.setFilms(this.films.stream()
                .map(it -> new Film(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setPeople(this.people.stream()
                .map(it -> new Person(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        this.setEntityValues(result);
        return result;
    }

}
