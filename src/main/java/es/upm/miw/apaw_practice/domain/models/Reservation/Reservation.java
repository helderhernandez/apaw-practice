package es.upm.miw.apaw_practice.domain.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private BigDecimal price;
    private LocalDateTime date;

    public Reservation() {
        //Empty for framework
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
