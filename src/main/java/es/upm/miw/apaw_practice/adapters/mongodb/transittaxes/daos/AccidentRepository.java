package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.AccidentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccidentRepository extends MongoRepository<AccidentEntity, String> {
}
