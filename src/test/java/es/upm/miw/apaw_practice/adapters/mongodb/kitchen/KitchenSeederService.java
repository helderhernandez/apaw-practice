package es.upm.miw.apaw_practice.adapters.mongodb.kitchen;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.KitchenBoyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.RecipeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.KitchenBoyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.RecipeEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class KitchenSeederService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private KitchenBoyRepository kitchenBoyRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Kitchen Initial Load -----------");

        IngredientEntity[] ingredients = {
                new IngredientEntity("Cacao en polvo", new BigDecimal(35), 0.1),
                new IngredientEntity("Calabaza", new BigDecimal(4.5), 0.5),
                new IngredientEntity("Avena", new BigDecimal(1), 0.2),
                new IngredientEntity("Calabacín", new BigDecimal(4.5), 2.0),
                new IngredientEntity("Calabaza", new BigDecimal(4.5), 2.5)
        };
        this.ingredientRepository.saveAll(Arrays.asList(ingredients));

        RecipeEntity[] recipes = {
                new RecipeEntity("Cupcakes", List.of(ingredients[0], ingredients[1], ingredients[2])),
                new RecipeEntity("Puré de calabaza", List.of(ingredients[4])),
                new RecipeEntity("Puré de calabacín", List.of(ingredients[3]))
        };
        recipes[0].setLastUseDate(LocalDateTime.now());
        this.recipeRepository.saveAll(Arrays.asList(recipes));

        KitchenBoyEntity[] kitchenBoys = {
                new KitchenBoyEntity("12345678A", 3, ingredients[1]),
                new KitchenBoyEntity("50129911B", 0, ingredients[3])
        };
        this.kitchenBoyRepository.saveAll(Arrays.asList(kitchenBoys));

    }

    public void deleteAll() {
        this.ingredientRepository.deleteAll();
        this.recipeRepository.deleteAll();
        this.kitchenBoyRepository.deleteAll();
    }
}
