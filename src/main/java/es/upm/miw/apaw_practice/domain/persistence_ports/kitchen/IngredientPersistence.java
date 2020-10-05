package es.upm.miw.apaw_practice.domain.persistence_ports.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IngredientPersistence {
    Stream<Ingredient> readAll();
}
