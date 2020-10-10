package es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.MuscleGroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MuscleGroupRepository extends MongoRepository<MuscleGroupEntity, String> {
    Optional<MuscleGroupEntity> findByName (String name);
}
