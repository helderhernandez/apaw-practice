package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccidentRepository extends MongoRepository<AccidentEntity, String> {
    Optional<AccidentEntity> findByRefAccident(String ref);
}
