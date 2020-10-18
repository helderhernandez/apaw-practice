package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CDVehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CDVehicleRepository extends MongoRepository<CDVehicleEntity, String> {
    Optional<CDVehicleEntity> findByFrameNumber(String frameNumber);
}