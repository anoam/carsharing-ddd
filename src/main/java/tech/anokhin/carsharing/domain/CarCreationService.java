package tech.anokhin.carsharing.domain;

// Same notices as for DriversCreationService
public class CarCreationService {
    private CarsRepository repository;
    public void setRepository(CarsRepository repository) { this.repository = repository; }

    public Car create(String registration) {
        if (repository.existsByRegistration(registration)) {
            throw new IllegalArgumentException("Car with given registration already exists");
        }

        Car result = new Car(registration);

        return repository.save(result);
    }
}
