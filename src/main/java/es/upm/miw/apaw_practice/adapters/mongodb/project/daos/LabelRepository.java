package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LabelRepository extends MongoRepository<LabelEntity, String> {
    Optional<LabelEntity> findById(String id);
}
