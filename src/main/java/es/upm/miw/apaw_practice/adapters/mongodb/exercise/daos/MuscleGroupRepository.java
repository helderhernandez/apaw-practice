package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.MuscleGroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MuscleGroupRepository extends MongoRepository<MuscleGroupEntity, String> {
    Optional<MuscleGroupEntity> findByName (String name);
}
