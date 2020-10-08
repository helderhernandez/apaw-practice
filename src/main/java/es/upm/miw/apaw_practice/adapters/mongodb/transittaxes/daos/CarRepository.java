package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.CarEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CarRepository extends MongoRepository<CarEntity, String> {
    Optional<CarEntity> findByEnrollment(String enrollment);
}
