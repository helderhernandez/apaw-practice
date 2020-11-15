package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PaintEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaintRepository extends MongoRepository<PaintEntity, String> {
    Optional<PaintEntity> findById(String id);
}
