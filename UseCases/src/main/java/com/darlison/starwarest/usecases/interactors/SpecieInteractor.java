package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Specie;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.SWGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecieInteractor implements SWBoundary<Specie> {

    @Autowired
    protected SWGateway<Specie> gateway;

    @Override
    public List<Specie> list(String name) {
        return gateway.list(name);
    }

    @Override
    public List<Specie> list(String param1, String param2) {
        return null;
    }

    @Override
    public Specie getById(Long id) {
        return gateway.getOne(id);
    }
}

