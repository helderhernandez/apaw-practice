package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class ChefEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private Integer recipesFinished;
    @DBRef
    private List<KitchenBoyEntity> kitchenBoys;

    public ChefEntity() {
        // Empty from framework
    }

    public ChefEntity(String dni, List<KitchenBoyEntity> kitchenBoys) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.recipesFinished = 0;
        this.kitchenBoys = kitchenBoys;
    }

    public String getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getRecipesFinished() {
        return recipesFinished;
    }

    public void setRecipesFinished(Integer recipesFinished) {
        this.recipesFinished = recipesFinished;
    }

    public List<KitchenBoyEntity> getKitchenBoys() {
        return kitchenBoys;
    }

    public void setKitchenBoys(List<KitchenBoyEntity> kitchenBoys) {
        this.kitchenBoys = kitchenBoys;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((ChefEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "ChefEntity{" +
                "id='" + id + '\'' +
                ", dni=" + dni + '\'' +
                ", recipesFinished=" + recipesFinished + '\'' +
                ", kitchenBoys=" + kitchenBoys + '\'' +
                '}';
    }
}
