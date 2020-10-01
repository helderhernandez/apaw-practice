package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class IngredientEntityRepositoryIT {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    void testFindByName(){
        assertTrue(this.ingredientRepository.findByName("Cacao en polvo").isPresent());
        IngredientEntity ingredient = this.ingredientRepository.findByName("Cacao en polvo").get();

    }
}
