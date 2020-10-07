package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class RestaurantEntity {
    @Id
    private String id;
    private String name;
    private Double score;
    @DBRef
    private List<PhysicalStoreEntity> physicalStoreEntities;
    @DBRef
    private List<FoodTypeEntity> foodTypeEntities;
    @DBRef
    private OwnerEntity ownerEntities;

    public RestaurantEntity() {
        //empty for framework
    }

    public RestaurantEntity(String name, Double score, List<PhysicalStoreEntity> physicalStoreEntities,
                            List<FoodTypeEntity> foodTypeEntities, OwnerEntity ownerEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.score = score;
        this.physicalStoreEntities = physicalStoreEntities;
        this.foodTypeEntities = foodTypeEntities;
        this.ownerEntities = ownerEntities;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<PhysicalStoreEntity> getPhysicalStoreEntities() {
        return physicalStoreEntities;
    }

    public void setPhysicalStoreEntities(List<PhysicalStoreEntity> physicalStoreEntities) {
        this.physicalStoreEntities = physicalStoreEntities;
    }

    public List<FoodTypeEntity> getFoodTypeEntities() {
        return foodTypeEntities;
    }

    public void setFoodTypeEntities(List<FoodTypeEntity> foodTypeEntities) {
        this.foodTypeEntities = foodTypeEntities;
    }

    public OwnerEntity getOwnerEntities() {
        return ownerEntities;
    }

    public void setOwnerEntities(OwnerEntity ownerEntities) {
        this.foodTypeEntities = foodTypeEntities;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((RestaurantEntity) obj).id));
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", physicalStoreEntities=" + physicalStoreEntities +
                ", foodTypeEntities=" + foodTypeEntities +
                ", ownerEntities=" + ownerEntities +
                '}';
    }
}
