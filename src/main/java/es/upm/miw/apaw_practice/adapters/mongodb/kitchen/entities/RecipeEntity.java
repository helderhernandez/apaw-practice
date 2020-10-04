package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class RecipeEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private LocalDateTime lastUseDate;
    private List<IngredientEntity> ingredients;

    public RecipeEntity() {
        //Empty from framework
    }

    public RecipeEntity(String name, List<IngredientEntity> ingredients){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
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

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((RecipeEntity) obj).name));
    }

    @Override
    public String toString() {
        return "RecipeEntity{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", lastUseDate=" + lastUseDate + '\'' +
                ", ingredients=" + ingredients + '\'' +
                '}';
    }
}
