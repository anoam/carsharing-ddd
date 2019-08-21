package tech.anokhin.carsharing.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.anokhin.carsharing.domain.CarCreationService;
import tech.anokhin.carsharing.domain.DriversCreationService;
import tech.anokhin.carsharing.domain.RentCarService;
import tech.anokhin.carsharing.service.CarsService;
import tech.anokhin.carsharing.webapp.repositories.CarsRepository;
import tech.anokhin.carsharing.webapp.repositories.DriversRepository;

@Configuration
public class Config {
    @Bean
    public DriversCreationService driversCreationService(@Autowired DriversRepository repository) {
        DriversCreationService service = new DriversCreationService();
        service.setRepository(repository);
        return service;
    }

    @Bean
    public CarCreationService carCreationService(@Autowired CarsRepository repository) {
        CarCreationService service = new CarCreationService();
        service.setRepository(repository);

        return service;
    }

    @Bean
    public CarsService carsService(@Autowired CarsRepository carsRepository, @Autowired DriversRepository driversRepository) {
        CarsService service = new CarsService();
        service.setCarsRepository(carsRepository);
        service.setDriversRepository(driversRepository);

        RentCarService rentService = new RentCarService();
        rentService.setRepository(carsRepository);
        service.setRentService(rentService);

        return service;
    }
}
