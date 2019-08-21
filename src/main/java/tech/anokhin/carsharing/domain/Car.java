package tech.anokhin.carsharing.domain;

public class Car {
    private String registration;
    private Driver currentDriver = null;
    private CarStatus status = CarStatus.FREE;

    // Default constructor is required by Hibernate
    public Car(){ this(""); }

    // We don't have any case to init a car with driver. Hibernate will use default constructor anyway
    Car(String registration) {
        this.registration = registration;
    }

    public String getRegistration() { return this.registration; }

    public Driver getCurrentDriver() {
        return currentDriver;
    }

    private boolean isRent() {
        return status == CarStatus.RENTED;
    }
    private boolean isFree() {
        return status == CarStatus.FREE;
    }

    void rent(Driver driver) {
        // We need to provide the invariant. No way we can re-rent a rented car.
        if (isRent())
            throw new IllegalArgumentException("Car is already rented");

        this.status = CarStatus.RENTED;
        currentDriver = driver;
    }

    public void free() {
        if (isFree())
            throw new IllegalArgumentException("Car is already free");

        this.currentDriver = null;
        this.status = CarStatus.FREE;
    }
}
