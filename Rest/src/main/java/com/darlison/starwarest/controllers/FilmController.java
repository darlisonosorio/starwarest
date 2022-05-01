package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    protected SWBoundary<Film> boundary;

    @GetMapping
    public List<Film> list(@RequestParam(required = false) String title) {
        return boundary.list(title);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id) {
        return boundary.getById(id);
    }


}
