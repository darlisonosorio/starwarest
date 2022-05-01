package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Starship;
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
public class StarshipModel extends BaseModel {

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

    private List<String> pilots;
    private List<String> films;

    public StarshipModel(
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
            List<String> pilots,
            List<String> films,
            String created,
            String edited,
            String url
    ) {
        super(created, edited, url);
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

    public Starship toEntity() {
        final Starship result = new Starship();
        result.setName(name);
        result.setModel(model);
        result.setStarshipClass(starshipClass);
        result.setManufacturer(manufacturer);
        result.setCostInCredits(costInCredits);
        result.setLength(length);
        result.setCrew(crew);
        result.setPassengers(passengers);
        result.setMaxAtmospheringSpeed(maxAtmospheringSpeed);
        result.setHyperdriveRating(hyperdriveRating);
        result.setMGLT(MGLT);
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
