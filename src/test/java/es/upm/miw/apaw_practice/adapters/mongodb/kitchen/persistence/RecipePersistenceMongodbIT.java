package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RecipePersistenceMongodbIT {

    @Autowired
    private RecipePersistenceMongodb recipePersistence;

    @Autowired
    private IngredientPersistenceMongodb ingredientPersistence;

    @Test
    void testCreateAndRead() {
        List<String> ingredientIds = this.ingredientPersistence.readAll()
                .filter(ingredient -> ingredient.getName().equals("Calabaza") || ingredient.getName().equals("Cacao en polvo"))
                .map(ingredient -> ingredient.getId())
                .collect(Collectors.toList());

        RecipeCreation recipeCreation = new RecipeCreation("Donuts", ingredientIds);
        Recipe recipeBD = this.recipePersistence.create(recipeCreation);
        assertEquals("Donuts", recipeBD.getName());
        assertTrue(ingredientIds.containsAll(recipeBD.getIngredientIds()));
        assertNotNull(recipeBD.getId());
        assertNull(recipeBD.getLastUseDate());
    }
}
