package es.upm.miw.apaw_practice.domain.services.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import es.upm.miw.apaw_practice.domain.models.kitchen.IngredientPricePerKgUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.IngredientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class IngredientService {

    private IngredientPersistence ingredientPersistence;

    @Autowired
    public IngredientService(IngredientPersistence ingredientPersistence) {
        this.ingredientPersistence = ingredientPersistence;
    }

    public Stream<Ingredient> readAll() {
        return this.ingredientPersistence.readAll();
    }

    public void updatePricesPerKg(List<IngredientPricePerKgUpdating> ingredientPricesPerKg) {
        ingredientPricesPerKg.stream()
                .map(ingredientPriceUpdating -> {
                    Ingredient ingredient = this.findIngredientById(ingredientPriceUpdating.getId());
                    ingredient.setPricePerKg(ingredientPriceUpdating.getPricePerKg());
                    return ingredient;
                })
                .forEach(ingredient -> this.ingredientPersistence.update(ingredient));
    }

    private Ingredient findIngredientById(String id) {
        return this.ingredientPersistence.readAll()
                .filter(ingredient -> ingredient.getId().equals(id))
                .findFirst().get();
    }

}
