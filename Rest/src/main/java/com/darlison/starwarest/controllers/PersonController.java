package com.darlison.starwarest.controllers;

import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people")
public class PersonController {

    @Autowired
    protected SWBoundary<Person> boundary;

    @GetMapping
    public List<Person> list(@RequestParam(required = false) String name) {
        return boundary.list(name);
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable Long id) {
        return boundary.getById(id);
    }


}
