package es.upm.miw.apaw_practice.adapters.mongodb.kitchen;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class KitchenSeederService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Kitchen Initial Load -----------");

        IngredientEntity[] ingredients = {
                new IngredientEntity("Cacao en polvo", new BigDecimal(35), 0.1),
                new IngredientEntity("Calabaza", new BigDecimal(4.5), 0.5),
                new IngredientEntity("Avena", new BigDecimal(1), 0.2),
                new IngredientEntity("Calabacín", new BigDecimal(4.5), 2.0),
        };
        this.ingredientRepository.saveAll(Arrays.asList(ingredients));
    }

    public void deleteAll() {
        this.ingredientRepository.deleteAll();
    }
}
