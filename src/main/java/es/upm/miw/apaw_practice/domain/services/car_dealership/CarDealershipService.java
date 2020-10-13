package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CarDealershipPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDealershipService {

    private CarDealershipPersistence carDealershipPersistence;

    @Autowired
    public CarDealershipService(CarDealershipPersistence carDealershipPersistence) {
        this.carDealershipPersistence = carDealershipPersistence;
    }

    public CarDealership readByName(String name) {
        return this.carDealershipPersistence.readByName(name);
    }
}
