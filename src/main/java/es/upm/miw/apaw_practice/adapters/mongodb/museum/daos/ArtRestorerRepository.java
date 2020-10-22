package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtRestorerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtRestorerRepository extends MongoRepository<ArtRestorerEntity, String> {
}
