package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.RecipeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RecipeRepository extends MongoRepository<RecipeEntity, String> {
    Optional<RecipeEntity> findByName(String name);
}
