package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class FoodTypeEntity {
    @Id
    private String id;
    private String type;
    private Boolean spicy;

    public FoodTypeEntity() {
        //empty for framework
    }

    public FoodTypeEntity(String id, String type, Boolean spicy) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.spicy = spicy;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Boolean getSpicy() { return spicy; }

    public void setSpicy(Boolean spicy) { this.spicy = spicy; }

    public void formFoodType(FoodType spicyUpdating) {
        BeanUtils.copyProperties(spicyUpdating,this);
    }

    public FoodType toFoodType() {
        FoodType foodType = new FoodType();
        BeanUtils.copyProperties(this, foodType);
        return foodType;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FoodTypeEntity) obj).id));
    }

    @Override
    public String toString() {
        return "PhysicalStoreEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", spicy='" + spicy + '\'' +
                '}';
    }
}
