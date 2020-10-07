package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.RecipeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.RecipeEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.kitchen.RecipePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("recipePersistence")
public class RecipePersistenceMongodb implements RecipePersistence {

    private RecipeRepository recipeRepository;

    private IngredientRepository ingredientRepository;

    @Autowired
    public RecipePersistenceMongodb(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Recipe create(RecipeCreation recipeCreation) {
        assertNameNotExists(recipeCreation.getName());
        List<IngredientEntity> recipeIngredients = this.ingredientRepository.findAll().stream()
                .filter(ingredient -> recipeCreation.getIngredientIds().contains(ingredient.getId()))
                .collect(Collectors.toList());
        return this.recipeRepository.save(new RecipeEntity(recipeCreation, recipeIngredients))
                .toRecipe();
    }

    public void assertNameNotExists(String name) {
        this.recipeRepository.findByName(name)
                .ifPresent(recipe -> {
                    throw new ConflictException("Recipe already exists: " + name);
                });
    }
}
