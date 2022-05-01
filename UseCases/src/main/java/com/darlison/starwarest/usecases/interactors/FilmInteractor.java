package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.SWGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmInteractor implements SWBoundary<Film> {

    @Autowired
    private SWGateway<Film> gateway;

    @Override
    public List<Film> list(String name) {
        return gateway.list(name);
    }

    @Override
    public List<Film> list(String param1, String param2) {
        return null;
    }

    @Override
    public Film getById(Long id) {
        return gateway.getOne(id);
    }
}

