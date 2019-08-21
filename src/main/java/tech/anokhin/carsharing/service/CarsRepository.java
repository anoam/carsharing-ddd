package tech.anokhin.carsharing.service;

import tech.anokhin.carsharing.domain.Car;

public interface CarsRepository extends tech.anokhin.carsharing.domain.CarsRepository {
    Car findByRegistration(String registration);
}
