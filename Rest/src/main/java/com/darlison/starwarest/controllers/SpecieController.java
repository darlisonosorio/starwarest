package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Specie;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("species")
public class SpecieController {

    @Autowired
    private SWBoundary<Specie> boundary;

    @GetMapping
    public List<Specie> list(@RequestParam(required = false) String name) {
        return boundary.list(name);
    }

    @GetMapping("/{id}")
    public Specie get(@PathVariable Long id) {
        return boundary.getById(id);
    }

}
