package es.upm.miw.apaw_practice.adapters.rest.airport;

import java.math.BigDecimal;

public class PriceDto {

    private BigDecimal price;

    public PriceDto() {

    }

    public PriceDto(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceDto{" +
                "price=" + price +
                '}';
    }
}
