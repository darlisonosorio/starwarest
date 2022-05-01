package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planets")
public class PlanetController {

    @Autowired
    private SWBoundary<Planet> boundary;

    @GetMapping
    public List<Planet> list(@RequestParam(required = false) String name) {
        return boundary.list(name);
    }

    @GetMapping("/{id}")
    public Planet get(@PathVariable Long id) {
        return boundary.getById(id);
    }

}
