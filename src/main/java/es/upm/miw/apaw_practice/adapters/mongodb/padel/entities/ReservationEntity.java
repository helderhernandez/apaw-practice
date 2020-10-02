package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
public class ReservationEntity {
    @Id
    private String id;
    private BigDecimal price;
    private LocalDate date;

    public ReservationEntity() {
        //Empty for framework
    }

    public ReservationEntity(BigDecimal price, LocalDate date) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((PlayerEntity) obj).getId()));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
