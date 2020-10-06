package es.upm.miw.apaw_practice.adapters.mongodb.airport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.airport.entities.PlaneEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlaneRepository extends MongoRepository<PlaneEntity, String> {

    Optional<PlaneEntity> findByLicensePlate(String licensePlate);
}
