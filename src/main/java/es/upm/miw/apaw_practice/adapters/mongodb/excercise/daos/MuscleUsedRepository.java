package es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.MuscleUsedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MuscleUsedRepository extends MongoRepository<MuscleUsedEntity, String> {
    Optional<MuscleUsedEntity> findByName (String name);
}
