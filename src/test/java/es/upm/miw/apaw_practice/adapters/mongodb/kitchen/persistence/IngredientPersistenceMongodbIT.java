package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class IngredientPersistenceMongodbIT {
    
    @Autowired
    private IngredientPersistenceMongodb ingredientPersistence;

    @Test
    void testReadAll() {
        assertTrue(this.ingredientPersistence.readAll()
                .map(Ingredient::getName)
                .collect(Collectors.toList())
                .containsAll(List.of("Cacao en polvo", "Calabaza", "Calabacín", "Avena")));
    }

    @Test
    void testUpdate() {
        Ingredient ingredient = this.ingredientPersistence.readAll()
                .findFirst().get();
        String lastName = ingredient.getName();

        ingredient.setName("Sape");
        Ingredient updatedIngredient = this.ingredientPersistence.update(ingredient);
        assertEquals("Sape", updatedIngredient.getName());

        ingredient.setName(lastName);
        this.ingredientPersistence.update(ingredient);
    }
}
