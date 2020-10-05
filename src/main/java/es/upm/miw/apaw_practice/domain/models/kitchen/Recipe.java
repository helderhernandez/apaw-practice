package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.time.LocalDateTime;
import java.util.List;

public class Recipe {
    private String id;
    private String name;
    private LocalDateTime lastUseDate;
    private List<String> ingredientsId;

    public Recipe() {
        //Empty from framework
    }

    public Recipe(String id, String name, List<String> ingredients){
        this.id = id;
        this.name = name;
        this.ingredientsId = ingredients;
    }

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

    public List<String> getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(List<String> ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", lastUseDate=" + lastUseDate + '\'' +
                ", ingredientsId=" + ingredientsId + '\'' +
                '}';
    }
}
