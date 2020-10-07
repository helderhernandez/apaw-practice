package es.upm.miw.apaw_practice.domain.models.airport;

import java.math.BigDecimal;

public class FlightPriceUpdating {

    private String id;
    private BigDecimal price;

    public FlightPriceUpdating() {
        //empty for framework
    }

    public FlightPriceUpdating(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FlightPriceUpdating{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
