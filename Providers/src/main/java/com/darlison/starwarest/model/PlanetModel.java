package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Planet;
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
public class PlanetModel extends BaseModel {

    private String name;
    private String diameter;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surfaceWater;

    private List<String> films;
    private List<String> residents;

    public PlanetModel(
        String name,
        String diameter,
        String rotationPeriod,
        String orbitalPeriod,
        String gravity,
        String population,
        String climate,
        String terrain,
        String surfaceWater,
        List<String> films,
        List<String> residents,
        String created,
        String edited,
        String url
    ) {
        super(created, edited, url);
        this.name = name;
        this.diameter = diameter;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.gravity = gravity;
        this.population = population;
        this.climate = climate;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.films = films;
        this.residents = residents;
    }

    public Planet toEntity() {
        final Planet result = new Planet();
        result.setName(name);
        result.setDiameter(diameter);
        result.setRotationPeriod(rotationPeriod);
        result.setOrbitalPeriod(orbitalPeriod);
        result.setGravity(gravity);
        result.setPopulation(population);
        result.setClimate(climate);
        result.setTerrain(terrain);
        result.setSurfaceWater(surfaceWater);
        result.setFilms(this.films.stream()
                .map(it -> new Film(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setResidents(this.residents.stream()
                .map(it -> new Person(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        this.setEntityValues(result);
        return result;
    }

}
