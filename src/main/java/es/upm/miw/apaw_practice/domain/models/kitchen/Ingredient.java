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

    public static IngredientBuilders.Id builder() {
        return new Builder();
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

    public static class Builder implements IngredientBuilders.Id, IngredientBuilders.Name, IngredientBuilders.PricePerKg, IngredientBuilders.WeightKg, IngredientBuilders.Optionals {

        private Ingredient ingredient;

        public Builder() {
            this.ingredient = new Ingredient();
        }


        @Override
        public IngredientBuilders.Name id(String id) {
            this.ingredient.id = id;
            return this;
        }

        @Override
        public IngredientBuilders.PricePerKg name(String name) {
            this.ingredient.name = name;
            return this;
        }

        @Override
        public IngredientBuilders.WeightKg pricePerKg(BigDecimal pricePerKg) {
            this.ingredient.pricePerKg = pricePerKg;
            return this;
        }

        @Override
        public IngredientBuilders.Optionals weightKg(Double weightKg) {
            this.ingredient.weightKg = weightKg;
            return this;
        }

        @Override
        public IngredientBuilders.Optionals washed(Boolean washed) {
            this.ingredient.washed = washed;
            return this;
        }

        @Override
        public IngredientBuilders.Optionals elaborated(Boolean elaborated) {
            this.ingredient.elaborated = elaborated;
            return this;
        }

        @Override
        public Ingredient build() {
            return this.ingredient;
        }
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
