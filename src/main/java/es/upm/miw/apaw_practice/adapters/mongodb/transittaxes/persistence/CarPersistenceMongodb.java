package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.CarRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.CarPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("VehiclePersistence")
public class CarPersistenceMongodb implements CarPersistence {

    private CarRepository carRepository;

    @Autowired
    public CarPersistenceMongodb(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car updateBrand(String id, String brand) {
        CarEntity carEntity = carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car id: " + id));
        carEntity.setBrand(brand);
        return carRepository.save(carEntity).toCar();
    }

    @Override
    public Stream<Car> readAll() {
        return this.carRepository.findAll().stream()
                .map(CarEntity::toCar);
    }
}
