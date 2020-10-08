package es.upm.miw.apaw_practice.domain.models.padel;

import java.math.BigDecimal;

public class RacketPriceUpdating {
    private String brand;
    private BigDecimal price;

    public RacketPriceUpdating() {
        //Empty for Spring
    }

    public RacketPriceUpdating(String brand, BigDecimal price) {
        this.brand = brand;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Racket{" +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
