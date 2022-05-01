package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.SWGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanetInteractor implements SWBoundary<Planet> {

    @Autowired
    protected SWGateway<Planet> gateway;

    @Override
    public List<Planet> list(String name) {
        return gateway.list(name);
    }

    @Override
    public List<Planet> list(String param1, String param2) {
        return null;
    }

    @Override
    public Planet getById(Long id) {
        return gateway.getOne(id);
    }
}

