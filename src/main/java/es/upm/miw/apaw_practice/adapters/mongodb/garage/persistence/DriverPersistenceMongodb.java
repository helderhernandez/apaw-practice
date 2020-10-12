package es.upm.miw.apaw_practice.adapters.mongodb.garage.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.DriverRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.DriverPersistence;
import org.springframework.stereotype.Repository;

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

    @Override
    public Driver create(DriverCreation driverCreation) {
        this.assertDniNotExist(driverCreation.getDni());
        DriverEntity driverEntity = new DriverEntity(driverCreation);
        return this.driverRepository.save(driverEntity).toDriver();
    }

}
