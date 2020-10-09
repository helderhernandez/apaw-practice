package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.math.BigDecimal;

public class Ingredient {
    private String id;
    private String name;
    private BigDecimal pricePerKg;
    private Double weightKg;
    private Boolean washed;
    private Boolean elaborated;

    public Ingredient() {
        // Empty from framework
    }

    public Ingredient(String id, String name, BigDecimal pricePerKg, Double weightKg){
        this.id = id;
        this.washed = false;
        this.elaborated = false;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weightKg = weightKg;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", pricePerKg=" + pricePerKg + '\'' +
                ", weightKg=" + weightKg + '\'' +
                ", washed=" + washed + '\'' +
                ", elaborated=" + elaborated + '\'' +
                '}';
    }
}
