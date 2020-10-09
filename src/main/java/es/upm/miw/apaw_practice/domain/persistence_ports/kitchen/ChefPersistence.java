package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefPersistence {
    Chef updateRecipesFinished(String dni, Integer recipesFinished);
}
