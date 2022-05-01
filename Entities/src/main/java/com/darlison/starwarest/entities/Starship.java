package com.darlison.starwarest.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Starship extends BaseEntity {

    private String name;
    private String model;
    private String starshipClass;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String crew;
    private String passengers;
    private String maxAtmospheringSpeed;
    private String hyperdriveRating;
    private String MGLT;
    private String cargoCapacity;
    private String consumables;

    private List<Person> pilots;
    private List<Film> films;

    public Starship(Long id) {
        super(id);
    }

    public Starship(
            Long id,
            String name,
            String model,
            String starshipClass,
            String manufacturer,
            String costInCredits,
            String length,
            String crew,
            String passengers,
            String maxAtmospheringSpeed,
            String hyperdriveRating,
            String MGLT,
            String cargoCapacity,
            String consumables,
            List<Person> pilots,
            List<Film> films,
            Date created,
            Date edited,
            String url
    ) {
        super(id, created, edited, url);
        this.name = name;
        this.model = model;
        this.starshipClass = starshipClass;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.crew = crew;
        this.passengers = passengers;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.hyperdriveRating = hyperdriveRating;
        this.MGLT = MGLT;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.pilots = pilots;
        this.films = films;
    }

}
