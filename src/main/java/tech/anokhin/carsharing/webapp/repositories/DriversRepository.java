package tech.anokhin.carsharing.webapp.repositories;

import org.springframework.data.repository.Repository;
import tech.anokhin.carsharing.domain.Driver;

@org.springframework.stereotype.Repository
public interface DriversRepository extends tech.anokhin.carsharing.service.DriversRepository, Repository<Driver, String> {
    Iterable<Driver> findAll();
}
