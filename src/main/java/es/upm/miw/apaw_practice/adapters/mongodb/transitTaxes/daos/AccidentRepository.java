package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.AccidentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccidentRepository extends MongoRepository<AccidentEntity, String> {
}
