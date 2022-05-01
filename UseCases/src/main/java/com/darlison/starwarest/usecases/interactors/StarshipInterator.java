package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.StarshipGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StarshipInterator implements SWBoundary<Starship> {

    @Autowired
    private StarshipGateway gateway;

    @Override
    public List<Starship> list(String param1) {
        return this.list(param1, null);
    }

    @Override
    public List<Starship> list(String param1, String param2) {
        return gateway.list(param1, param2);
    }

    @Override
    public Starship getById(Long id) {
        return gateway.getOne(id);
    }
}
