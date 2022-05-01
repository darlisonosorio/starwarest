package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Vehicle;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    protected SWBoundary<Vehicle> boundary;

    @GetMapping
    public List<Vehicle> list(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String model) {
        return boundary.list(name, model);
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Long id) {
        return boundary.getById(id);
    }

}
