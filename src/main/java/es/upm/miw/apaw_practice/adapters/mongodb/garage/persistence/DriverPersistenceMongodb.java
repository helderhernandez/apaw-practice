package es.upm.miw.apaw_practice.adapters.mongodb.garage.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.DriverPersistence;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("driverPersistence")
public class DriverPersistenceMongodb implements DriverPersistence {

    private final DriverRepository driverRepository;

    public DriverPersistenceMongodb(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    private void assertDniNotExist(String dni) {
        this.driverRepository
                .findByDni(dni)
                .ifPresent(driver -> {
                    throw new ConflictException("Driver exist: " + dni);
                });
    }

    private void assertDniExist(String dni) {
        this.driverRepository
                .findByDni(dni)
                .ifPresentOrElse(driver -> {
                                    // do nothing
                                },
                                () -> {
                                    throw new ConflictException("Driver not exist: " + dni);
                                });

    }

    @Override
    public Driver create(DriverCreation driverCreation) {
        this.assertDniNotExist(driverCreation.getDni());
        DriverEntity driverEntity = new DriverEntity(driverCreation);
        return this.driverRepository.save(driverEntity).toDriver();
    }

    @Override
    public void delete(String dni) {
        this.assertDniExist(dni);
        this.driverRepository.deleteByDni(dni);
    }

    @Override
    public Stream<String> findMechanicNamesByDriverName(String driverName) {
        return this.driverRepository
                .findAll()
                .stream()
                .filter(driver -> driver.getName().equals(driverName))
                .flatMap(driver -> driver.getVehicleEntities().stream())
                .flatMap(vehicleEntity -> vehicleEntity.getMechanicEntities().stream())
                .distinct()
                .map(mechanicEntity -> mechanicEntity.getName());
    }

}
