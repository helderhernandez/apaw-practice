package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaintRepository extends MongoRepository<PaintEntity, String> {
}
