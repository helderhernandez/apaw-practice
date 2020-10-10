package es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.ExerciseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseRepository extends MongoRepository<ExerciseEntity, String> {
    Optional<ExerciseEntity> findById(String name);
}
