package tech.anokhin.carsharing.domain;

public interface CarsRepository {
    Car save(Car car);
    // Pretty ugly names, aren't they? But it is made by agreement, so Spring will genarate it
    // Or we can use some extra XML configuration to get a cute name
    boolean existsByRegistration(String registration);
    boolean existsByCurrentDriver(Driver driver);
}
