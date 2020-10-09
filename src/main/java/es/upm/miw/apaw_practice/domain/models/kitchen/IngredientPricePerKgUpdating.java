package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.math.BigDecimal;

public class IngredientPricePerKgUpdating {
    private String id;
    private BigDecimal pricePerKg;

    public IngredientPricePerKgUpdating() {
        //Empty from framework
    }

    public IngredientPricePerKgUpdating(String id, BigDecimal pricePerKg) {
        this.id = id;
        this.pricePerKg = pricePerKg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return "IngredientPricePerKgUpdating{" +
                "id='" + id + '\'' +
                ", pricePerKg=" + pricePerKg + '\'' +
                '}';
    }
}
