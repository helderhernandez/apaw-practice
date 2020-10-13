package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipePersistence {
    Recipe create(RecipeCreation recipeCreation);
}
