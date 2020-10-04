package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
public class IngredientEntity {
    @Id
    private String id;
    private String name;
    private BigDecimal pricePerKg;
    private Double weightKg;
    private Boolean washed;
    private Boolean elaborated;

    public IngredientEntity() {
        // Empty from framework
    }

    public IngredientEntity(String name, BigDecimal pricePerKg, Double weightKg){
        this.id = UUID.randomUUID().toString();
        this.washed = false;
        this.elaborated = false;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weightKg = weightKg;
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

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public Boolean getWashed() {
        return washed;
    }

    public void setWashed(Boolean washed) {
        this.washed = washed;
    }

    public Boolean getElaborated() {
        return elaborated;
    }

    public void setElaborated(Boolean elaborated) {
        this.elaborated = elaborated;
    }

    public BigDecimal calculatePrice(){
        return pricePerKg.multiply(BigDecimal.valueOf(weightKg));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((IngredientEntity) obj).id));
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", pricePerKg=" + pricePerKg + '\'' +
                ", weightKg=" + weightKg + '\'' +
                ", washed=" + washed + '\'' +
                ", elaborated=" + elaborated + '\'' +
                '}';
    }
}
