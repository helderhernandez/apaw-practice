package es.upm.miw.apaw_practice.domain.services.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.IngredientPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
