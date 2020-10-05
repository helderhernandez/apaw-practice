package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IngredientRepository extends MongoRepository<IngredientEntity, String> {
    List<IngredientEntity> findByName(String name);
}
