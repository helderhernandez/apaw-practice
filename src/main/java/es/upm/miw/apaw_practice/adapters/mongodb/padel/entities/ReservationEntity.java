package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import es.upm.miw.apaw_practice.domain.models.padel.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class ReservationEntity {
    @Id
    private String id;
    private BigDecimal price;
    private LocalDateTime date;

    public ReservationEntity() {
        //Empty for framework
    }

    public ReservationEntity(BigDecimal price, LocalDateTime date) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public Reservation toReservation() {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(this,reservation);
        return reservation;
    }
}
