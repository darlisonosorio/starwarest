package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.SWGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonInteractor implements SWBoundary<Person> {

    @Autowired
    protected SWGateway<Person> gateway;

    @Override
    public List<Person> list(String name) {
        return gateway.list(name);
    }

    @Override
    public List<Person> list(String param1, String param2) {
        return null;
    }

    @Override
    public Person getById(Long id) {
        return gateway.getOne(id);
    }
}
