package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleGarageRepository extends MongoRepository<VehicleEntity, String> {
    Optional<VehicleEntity> findByCarRegistration(String carRegistration);
}
