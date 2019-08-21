package tech.anokhin.carsharing.webapp.repositories;

import org.springframework.data.repository.Repository;
import tech.anokhin.carsharing.domain.Car;

@org.springframework.stereotype.Repository
public interface CarsRepository extends tech.anokhin.carsharing.service.CarsRepository, Repository<Car, String> {
    Iterable<Car> findAll();
}
