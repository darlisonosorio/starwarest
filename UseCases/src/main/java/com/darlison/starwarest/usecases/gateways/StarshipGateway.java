package com.darlison.starwarest.usecases.gateways;

import com.darlison.starwarest.entities.Starship;

import java.util.List;

public interface StarshipGateway extends SWGateway<Starship> {

    List<Starship> list(String param1, String param2);

}
