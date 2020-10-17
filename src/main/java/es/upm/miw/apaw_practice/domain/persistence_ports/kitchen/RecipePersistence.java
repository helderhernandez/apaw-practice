package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RecipePersistence {
    Recipe create(RecipeCreation recipeCreation);
    Stream<Recipe> search1(String dni);
}
