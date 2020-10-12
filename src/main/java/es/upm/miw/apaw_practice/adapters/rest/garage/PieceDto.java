package es.upm.miw.apaw_practice.adapters.rest.garage;

import java.math.BigDecimal;

public class PieceDto {
    private BigDecimal price;

    public PieceDto() {
        // empty for framework
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
