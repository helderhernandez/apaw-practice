package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class IngredientEntityRepositoryIT {

    @Autowired
    private IngredientRepository ingredientRepository;

    private IngredientEntity ingredient;

    @BeforeEach
    void before(){
        assertTrue(!this.ingredientRepository.findByName("Cacao en polvo").isEmpty());
        ingredient = this.ingredientRepository.findByName("Cacao en polvo").stream()
                .findFirst()
                .get();
    }

    @Test
    void testSearchByPriceKg(){
        List<IngredientEntity> ingredients = this.ingredientRepository.findAll().stream()
                .filter(ingredient -> ingredient.getPricePerKg().equals(new BigDecimal(4.5)))
                .collect(Collectors.toList());
        assertEquals("Calabaza", ingredients.get(0).getName());
        assertEquals("Calabacín", ingredients.get(1).getName());
    }

    @Test
    void testGetMethods(){
        assertEquals("Cacao en polvo", ingredient.getName());
        assertEquals(new BigDecimal(35), ingredient.getPricePerKg());
        assertEquals(0.1, ingredient.getWeightKg());
        assertEquals(false, ingredient.getElaborated());
        assertEquals(false, ingredient.getWashed());
    }

    @Test
    void testSetMethods(){
        ingredient.setElaborated(true);
        ingredient.setWashed(true);
        ingredient.setName("Cacao");
        ingredient.setPricePerKg(new BigDecimal(36.5));
        ingredient.setWeightKg(0.2);

        assertEquals(true, ingredient.getElaborated());
        assertEquals(true, ingredient.getWashed());
        assertEquals("Cacao", ingredient.getName());
        assertEquals(new BigDecimal(36.5), ingredient.getPricePerKg());
        assertEquals(0.2, ingredient.getWeightKg());
    }

    @Test
    void testOtherMethods(){
        assertEquals(new BigDecimal(3.5), ingredient.calculatePrice());
    }
}
