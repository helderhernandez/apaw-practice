package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.MuscleUsedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MuscleUsedRepository extends MongoRepository<MuscleUsedEntity, String> {
    Optional<MuscleUsedEntity> findByName (String name);
}
