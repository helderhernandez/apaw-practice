package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.DriverEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<DriverEntity, String> {
    Optional<DriverEntity> findByDni(String dni);

    void deleteByDni(String dni);
}
