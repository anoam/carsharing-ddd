package tech.anokhin.carsharing.domain;

public interface DriversRepository {
    Driver save(Driver driver);
    boolean existsByLicense(String license);
}
