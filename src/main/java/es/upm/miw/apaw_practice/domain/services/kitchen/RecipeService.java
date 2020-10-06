package es.upm.miw.apaw_practice.domain.services.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.RecipePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private RecipePersistence recipePersistence;

    @Autowired
    public RecipeService(RecipePersistence recipePersistence) {
        this.recipePersistence = recipePersistence;
    }

    public Recipe create(RecipeCreation recipeCreation) {
        return this.recipePersistence.create(recipeCreation);
    }

}
