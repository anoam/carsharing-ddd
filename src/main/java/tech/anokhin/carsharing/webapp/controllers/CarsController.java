package tech.anokhin.carsharing.webapp.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.anokhin.carsharing.domain.Car;
import tech.anokhin.carsharing.domain.CarCreationService;
import tech.anokhin.carsharing.service.CarsService;
import tech.anokhin.carsharing.webapp.repositories.CarsRepository;

@RestController
@RequestMapping("cars")
public class CarsController {
    private CarsRepository repository;
    private CarCreationService creationService;
    private CarsService carsService;

    @Autowired
    public void setRepository(CarsRepository repository) { this.repository = repository; }
    @Autowired
    public void setCreationService(CarCreationService service) { this.creationService = service; }
    @Autowired
    public void setCarsService(CarsService carsService) { this.carsService = carsService; }

    @GetMapping(value = "/", produces = "application/json")
    public Iterable<Car> index() {
        return repository.findAll();
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public Car create(@RequestBody ObjectNode json) {
        String registration  = json.get("registration").asText();

        return creationService.create(registration);
    }

    @PostMapping(value = "/rent", consumes = "application/json", produces = "application/json")
    public Car rent(@RequestBody ObjectNode json) {
        String registration  = json.get("registration").asText();
        String license  = json.get("license").asText();

        return carsService.rent(registration, license);
    }

    @PostMapping(value = "/free", consumes = "application/json", produces = "application/json")
    public Car free(@RequestBody ObjectNode json) {
        String registration  = json.get("registration").asText();

        return carsService.free(registration);
    }
}
