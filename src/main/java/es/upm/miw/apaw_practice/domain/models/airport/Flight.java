package es.upm.miw.apaw_practice.domain.models.airport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {

    private String id;
    private LocalDateTime date;
    private BigDecimal price;
    private Plane plane;
    private String destinationCity;

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

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", plane=" + plane +
                ", destinationCity='" + destinationCity + '\'' +
                '}';
    }
}
