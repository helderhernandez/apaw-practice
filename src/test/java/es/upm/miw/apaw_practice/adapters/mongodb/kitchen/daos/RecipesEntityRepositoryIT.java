package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.RecipeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RecipesEntityRepositoryIT {
    @Autowired
    private RecipeRepository recipeRepository;

    private RecipeEntity recipe;

    @BeforeEach
    void before(){
        assertTrue(this.recipeRepository.findByName("Cupcakes").isPresent());
        recipe = this.recipeRepository.findByName("Cupcakes").get();
    }

    @Test
    void testSetAndGet() {
        recipe.setName("ChocolateCupcakes");
        assertEquals("ChocolateCupcakes", recipe.getName());
        assertEquals(true, recipe.getLastUseDate().isBefore(LocalDateTime.now()));

        LocalDateTime lastUse = recipe.getLastUseDate();
        recipe.setLastUseDate(LocalDateTime.now());
        assertEquals(true, lastUse.isBefore(recipe.getLastUseDate()));

        List<IngredientEntity> newIngredients = recipe.getIngredients();
        newIngredients.add(new IngredientEntity("Azucar", new BigDecimal(1.5), 0.1));
        recipe.setIngredients(newIngredients);

        assertTrue(recipe.getIngredients().stream()
                .map(ingredient -> ingredient.getName())
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("Cacao en polvo", "Calabaza", "Avena", "Azucar")));
    }

    @Test
    void testEquals(){
        RecipeEntity equalRecipe = new RecipeEntity("Cupcakes", recipe.getIngredients());
        assertTrue(recipe.equals(equalRecipe));
        assertTrue(!recipe.equals(recipeRepository.findByName("Puré de calabaza")));
    }

}
