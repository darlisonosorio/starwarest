package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Vehicle;
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
public class VehicleModel extends BaseModel {

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

    private List<String> films;
    private List<String> pilots;

    public VehicleModel(
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
            List<String> films,
            List<String> pilots,
            String created,
            String edited,
            String url
    ) {
        super(created, edited, url);
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

    public Vehicle toEntity() {
        final Vehicle result = new Vehicle();
        result.setName(name);
        result.setModel(model);
        result.setVehicleClass(vehicleClass);
        result.setManufacturer(manufacturer);
        result.setLength(length);
        result.setCostInCredits(costInCredits);
        result.setCrew(crew);
        result.setPassengers(passengers);
        result.setMaxAtmospheringSpeed(maxAtmospheringSpeed);
        result.setCargoCapacity(cargoCapacity);
        result.setConsumables(consumables);
        result.setPilots(this.pilots.stream()
                .map(it -> new Person(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        result.setFilms(this.films.stream()
                .map(it -> new Film(extractIdFromUrl(it)))
                .collect(Collectors.toList()));
        this.setEntityValues(result);
        return result;
    }

}
