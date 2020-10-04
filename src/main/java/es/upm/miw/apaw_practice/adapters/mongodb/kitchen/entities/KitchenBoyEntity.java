package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class KitchenBoyEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private Integer workExperienceYears;
    private IngredientEntity ingredientToWorkOn;

    public KitchenBoyEntity() {
        //Empty from framework
    }

    public KitchenBoyEntity(String dni, Integer workExperienceYears, IngredientEntity ingredientToWorkOn) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.workExperienceYears = workExperienceYears;
        this.ingredientToWorkOn = ingredientToWorkOn;
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

    public Integer getWorkExperienceYears() {
        return workExperienceYears;
    }

    public void setWorkExperienceYears(Integer workExperienceYears) {
        this.workExperienceYears = workExperienceYears;
    }

    public IngredientEntity getIngredientToWorkOn() {
        return ingredientToWorkOn;
    }

    public void setIngredientToWorkOn(IngredientEntity ingredientToWorkOn) {
        this.ingredientToWorkOn = ingredientToWorkOn;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((KitchenBoyEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "KitchenBoyEntity{" +
                "id='" + id + '\'' +
                ", dni=" + dni + '\'' +
                ", workExperienceYears=" + workExperienceYears + '\'' +
                ", ingredientToWorkOn=" + ingredientToWorkOn + '\'' +
                '}';
    }
}
