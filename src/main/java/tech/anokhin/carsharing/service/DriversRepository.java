package tech.anokhin.carsharing.service;

import tech.anokhin.carsharing.domain.Driver;

public interface DriversRepository extends tech.anokhin.carsharing.domain.DriversRepository {
    Driver findByLicense(String license);
}
