package com.darlison.starwarest.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Vehicle extends BaseEntity {

    private String name;
    private String model;
    private String vehicleClass;
    private String manufacturer;
    private String length;
    private String costInCredits;
    private String crew;
    private String passengers;
    private String maxAtmospheringSpeed;
    private String cargoCapacity;
    private String consumables;

    private List<Film> films;
    private List<Person> pilots;

    public Vehicle(Long id) {
        super(id);
    }

    public Vehicle(
            Long id,
            String name,
            String model,
            String vehicleClass,
            String manufacturer,
            String length,
            String costInCredits,
            String crew,
            String passengers,
            String maxAtmospheringSpeed,
            String cargoCapacity,
            String consumables,
            List<Film> films,
            List<Person> pilots,
            Date created,
            Date edited,
            String url
    ) {
        super(id, created, edited, url);
        this.name = name;
        this.model = model;
        this.vehicleClass = vehicleClass;
        this.manufacturer = manufacturer;
        this.length = length;
        this.costInCredits = costInCredits;
        this.crew = crew;
        this.passengers = passengers;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.films = films;
        this.pilots = pilots;
    }

}
