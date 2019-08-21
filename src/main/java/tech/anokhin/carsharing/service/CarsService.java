package tech.anokhin.carsharing.service;

import tech.anokhin.carsharing.domain.Car;
import tech.anokhin.carsharing.domain.Driver;
import tech.anokhin.carsharing.domain.RentCarService;

// This service provides application-specific logic.
// I.e. getting required entities from the repository
public class CarsService {
    // In some cases service layer should be responsible for creation if it assumes only to build an entity by some date
    // But in this example, there are some business requirements for this process.
    private RentCarService rentService;
    public void setRentService(RentCarService service) { this.rentService = service; }

    private CarsRepository carsRepository;
    public void setCarsRepository(CarsRepository repository) { this.carsRepository = repository; }

    private DriversRepository driversRepository;
    public void setDriversRepository(DriversRepository repository) { this.driversRepository = repository; }

    public Car rent(String registration, String license) {
        Car car = carsRepository.findByRegistration(registration);
        if (car == null)
            throw new IllegalArgumentException("The car doesn't exists");

        Driver driver = driversRepository.findByLicense(license);
        if (driver == null)
            throw new IllegalArgumentException("The driver doesn't exists");

        rentService.rent(car, driver);

        return carsRepository.save(car);
    }

    public Car free(String registration) {
        Car car = carsRepository.findByRegistration(registration);
        if (car == null)
            throw new IllegalArgumentException("The car doesn't exists");

        // We don't need domain service here since car will do the rest.
        car.free();

        return carsRepository.save(car);
    }
}
