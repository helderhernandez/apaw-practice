package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PatronEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatronRepository extends MongoRepository<PatronEntity, String> {
}
