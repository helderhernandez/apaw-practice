package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDVehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CDVehicleRepository extends MongoRepository<CDVehicleEntity, String> {
}