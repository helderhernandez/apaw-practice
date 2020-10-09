package es.upm.miw.apaw_practice.domain.models.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;

import java.util.List;

public class RecipeCreation {
    public String name;
    public List<String> ingredientIds;

    public RecipeCreation() {
        //Empty from framework
    }

    public RecipeCreation(String name, List<String> ingredientIds) {
        this.name = name;
        this.ingredientIds = ingredientIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<String> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    @Override
    public String toString() {
        return "RecipeCreationDto{" +
                "name=" + name + '\'' +
                ", ingredients=" + ingredientIds + '\'' +
                '}';
    }
}
