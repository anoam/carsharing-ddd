package tech.anokhin.carsharing.domain;

public class Driver {
    private String name;
    private String license;

    // Default constructor is required by Hibernate
    public Driver() {
        this("", "");
    }

    public Driver(String name, String license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }
}
