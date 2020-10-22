package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ChefPersistence {
    Chef updateRecipesFinished(String dni, Integer recipesFinished);
    Stream<String> findChefsDniThatHaveAKitchenBoyUsingIngredient(String ingredientName);
}
