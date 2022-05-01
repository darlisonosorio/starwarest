package com.darlison.starwarest.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Planet extends BaseEntity {

    private String name;
    private String diameter;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surfaceWater;

    private List<Film> films;
    private List<Person> residents;

    public Planet(Long id) {
        super(id);
    }

    public Planet(
        Long id,
        String name,
        String diameter,
        String rotationPeriod,
        String orbitalPeriod,
        String gravity,
        String population,
        String climate,
        String terrain,
        String surfaceWater,
        List<Film> films,
        List<Person> residents,
        Date created,
        Date edited
    ) {
        super(id, created, edited);
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

}
