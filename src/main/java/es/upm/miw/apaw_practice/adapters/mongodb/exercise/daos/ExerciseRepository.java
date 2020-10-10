package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.ExerciseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseRepository extends MongoRepository<ExerciseEntity, String> {
    Optional<ExerciseEntity> findByName(String name);
}
