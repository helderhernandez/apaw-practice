package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CDEmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CDEmployeeRepository extends MongoRepository<CDEmployeeEntity, String> {
    Optional<CDEmployeeEntity> readById(String id);
}