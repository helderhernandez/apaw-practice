package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IngredientRepository extends MongoRepository<IngredientEntity, String> {
    Optional<IngredientEntity> findByName(String name);
}
