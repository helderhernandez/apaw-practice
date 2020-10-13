package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Document
public class FlightEntity {

    @Id
    private String id;
    private LocalDateTime date;
    private BigDecimal price;
    @DBRef
    private PlaneEntity planeEntity;
    private String destinationCity;

    public FlightEntity() {
        //empty for framework
    }

    public FlightEntity(LocalDateTime date, BigDecimal price, PlaneEntity planeEntity, String destinationCity) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.price = price;
        this.planeEntity = planeEntity;
        this.destinationCity = destinationCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PlaneEntity getPlaneEntity() {
        return planeEntity;
    }

    public void setPlaneEntity(PlaneEntity planeEntity) {
        this.planeEntity = planeEntity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Flight toFlight() {
        return Flight.builder(id)
                .price(price)
                .date(date)
                .destinationCity(destinationCity)
                .Plane(planeEntity.toPlane())
                .build();
    }

    public void fromFlight(Flight flight) {
        BeanUtils.copyProperties(flight, this, "plane");
        this.setPlaneEntity(new PlaneEntity(flight.getPlane()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(price, that.price) &&
                Objects.equals(planeEntity, that.planeEntity) &&
                Objects.equals(destinationCity, that.destinationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, price, planeEntity, destinationCity);
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", planeEntity=" + planeEntity +
                ", destinationCity='" + destinationCity + '\'' +
                '}';
    }
}
