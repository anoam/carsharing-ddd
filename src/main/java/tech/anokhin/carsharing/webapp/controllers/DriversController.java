package tech.anokhin.carsharing.webapp.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.anokhin.carsharing.domain.Driver;
import tech.anokhin.carsharing.domain.DriversCreationService;
import tech.anokhin.carsharing.webapp.repositories.DriversRepository;

@RestController
@RequestMapping("drivers")
public class DriversController {
    private DriversRepository repository;
    private DriversCreationService creationService;

    @Autowired
    public void setRepository(DriversRepository repository) {
        this.repository = repository;
    }
    @Autowired
    public void setCreationService(DriversCreationService service) {
        this.creationService = service;
    }

    @GetMapping(value = "/", produces = "application/json")
    public Iterable<Driver> index() {
        return repository.findAll();
    }

    // 1. In real life it would be nice to use DTO instead of parsing request the way we do. I just don't want to create a class for DTO for only two attributes.
    // 2. IllegalArgumentException will cause 500. Processing exceptions with spring isn't a goal here.
    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public Driver create(@RequestBody ObjectNode json) {
        String name  = json.get("name").asText();
        String license = json.get("license").asText();

        return creationService.create(name, license);
    }
}
