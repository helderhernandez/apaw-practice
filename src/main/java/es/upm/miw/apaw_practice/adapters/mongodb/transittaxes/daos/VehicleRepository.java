package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface VehicleRepository extends MongoRepository<VehicleEntity, String> {
    Optional<VehicleEntity> findByEnrollment(String enrollment);
}
