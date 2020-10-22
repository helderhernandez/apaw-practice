package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.CollectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectionRepository extends MongoRepository<CollectionEntity, String> {
}
