package tech.anokhin.carsharing.domain;

// Ensures that the given car can be rented by the given driver. I.e. provides invariant.
public class RentCarService {
    private CarsRepository repository;
    public void setRepository(CarsRepository repository) { this.repository = repository; }

    public void rent(Car car, Driver driver) {
        // Depending on requirements these conditions can be extracted to a policy
        if (repository.existsByCurrentDriver(driver)) {
            throw new IllegalArgumentException("Driver is already renting a car");
        }
        // car itself will check if it is ready to be rent
        car.rent(driver);
    }
}
