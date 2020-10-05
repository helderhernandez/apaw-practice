package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.IngredientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.stream.Stream;

@Repository("ingredientPersistence")
public class IngredientPersistenceMongodb implements IngredientPersistence {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientPersistenceMongodb(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Stream<Ingredient> readAll() {
        return this.ingredientRepository.findAll().stream()
                .map(IngredientEntity::toIngredient);
        }
}
