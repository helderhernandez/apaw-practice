package es.upm.miw.apaw_practice.domain.services.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.CarPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private CarPersistence carPersistence;

    @Autowired
    public CarService(CarPersistence carPersistence) {
        this.carPersistence = carPersistence;
    }

    public Car updateBrand(String id, String brand) {
        return carPersistence.updateBrand(id, brand);
    }
}
