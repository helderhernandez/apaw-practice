package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CarDealershipRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CarDealershipPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("carDealershipPersistence")
public class CarDealershipPersistenceMongodb implements CarDealershipPersistence {

    private CarDealershipRepository carDealershipRepository;

    @Autowired
    public CarDealershipPersistenceMongodb(CarDealershipRepository carDealershipRepository) {
        this.carDealershipRepository = carDealershipRepository;
    }

    @Override
    public CarDealership readByName(String name) {
        return this.carDealershipRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Car Dealership name: " + name))
                .toCarDealership();
    }
}
