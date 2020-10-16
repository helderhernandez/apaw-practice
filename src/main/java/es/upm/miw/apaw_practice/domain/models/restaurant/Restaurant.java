package es.upm.miw.apaw_practice.domain.models.restaurant;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private Double score;
    private List<PhysicalStore> physicalStoreEntities;
    private List<FoodType> foodTypeEntities;
    private OwnerRestaurant ownerEntities;

    public Restaurant() {
        //Empty for framework
    }

    public Restaurant(String id, String name, Double score, List<PhysicalStore> physicalStoreEntities,
                      List<FoodType> foodTypeEntities, OwnerRestaurant ownerEntities) {
        this.id = id;
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

    public List<PhysicalStore> getPhysicalStoreEntities() {
        return physicalStoreEntities;
    }

    public void setPhysicalStoreEntities(List<PhysicalStore> physicalStoreEntities) {
        this.physicalStoreEntities = physicalStoreEntities;
    }

    public List<FoodType> getFoodTypeEntities() {
        return foodTypeEntities;
    }

    public void setFoodTypeEntities(List<FoodType> foodTypeEntities) {
        this.foodTypeEntities = foodTypeEntities;
    }

    public OwnerRestaurant getOwnerEntities() {
        return ownerEntities;
    }

    public void setOwnerEntities(OwnerRestaurant ownerEntities) {
        this.ownerEntities = ownerEntities;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", physicalStoreEntities=" + physicalStoreEntities +
                ", foodTypeEntities=" + foodTypeEntities +
                ", ownerEntities=" + ownerEntities +
                '}';
    }
}
