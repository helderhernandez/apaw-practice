package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class TicketBusEntity {
    @Id
    private String id;
    private Integer seat;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private BigDecimal price;

    @DBRef
    private PassengerEntity passenger;

    public TicketBusEntity() {
        //empty from framework
    }

    public TicketBusEntity(Integer seat, LocalDateTime departureTime, LocalDateTime arriveTime, BigDecimal price, PassengerEntity passenger) {
        this.id = UUID.randomUUID().toString();
        this.seat = seat;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.price = price;
        this.passenger = passenger;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketBusEntity that = (TicketBusEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "TicketBusEntity{" +
                "id='" + id + '\'' +
                ", seat=" + seat +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", price=" + price +
                ", passenger=" + passenger +
                '}';
    }
}
