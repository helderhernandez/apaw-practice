package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.time.LocalDateTime;
import java.util.List;

public class Recipe {
    private String id;
    private String name;
    private LocalDateTime lastUseDate;
    private List<String> ingredientIds;

    public Recipe() {
        //Empty from framework
    }

    /*
    public Recipe(String id, String name, List<String> ingredients){
        this.id = id;
        this.name = name;
        this.ingredientIds = ingredients;
    }
    */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUseDate() {
        return lastUseDate;
    }

    public void setLastUseDate(LocalDateTime lastUseDate) {
        this.lastUseDate = lastUseDate;
    }

    public List<String> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<String> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }

    public static Builder builder(String id, String name, List<String> ingredients) {
        return new Builder(id, name, ingredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", lastUseDate=" + lastUseDate + '\'' +
                ", ingredientIds=" + ingredientIds + '\'' +
                '}';
    }

    public static class Builder {
        private Recipe recipe;

        private Builder(String id, String name, List<String> ingredientIds) {
            this.recipe = new Recipe();
            this.recipe.id = id;
            this.recipe.name = name;
            this.recipe.ingredientIds = ingredientIds;
        }

        public Builder lastUseDate(LocalDateTime lastUseTime) {
            this.recipe.setLastUseDate(lastUseTime);
            return this;
        }

        public Recipe build() {
            return this.recipe;
        }
    }

}

