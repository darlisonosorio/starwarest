package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("starships")
public class StarshipController {

    @Autowired
    protected SWBoundary<Starship> boundary;

    @GetMapping
    public List<Starship> list(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String model) {
        return boundary.list(name, model);
    }

    @GetMapping("/{id}")
    public Starship get(@PathVariable Long id) {
        return boundary.getById(id);
    }

}
