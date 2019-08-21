package tech.anokhin.carsharing.domain;

// Very often this sort of object creation should go to the service layer. But in this particular case we must ensure the uniqueness.
public class DriversCreationService {

    private DriversRepository repository;

    public void setRepository(DriversRepository repository) {
        this.repository = repository;
    }

    // With real application most likely we'll need a DTO to deal with all drivers' attributes.
    // But in this particular case we have only 2 parameters, so DTO could be a kind of overhead
    public Driver create(String name, String license) {
        // For this example we've accepted that data is always correct itself.
        // But we still need to check uniqueness of licenses.
        // If we wanted to validate attributes, most likely it would be factory's responsibilities
        if (repository.existsByLicense(license)) {
            throw new IllegalArgumentException("Driver with given license already exists");
        }

        Driver result = new Driver(name, license);

        // Kinda CQRS violation, but it doesn't matter
        return repository.save(result);
    }
}
