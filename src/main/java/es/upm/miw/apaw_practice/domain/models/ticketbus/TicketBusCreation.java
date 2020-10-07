package es.upm.miw.apaw_practice.domain.models.ticketbus;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketBusCreation {

    private Integer seat;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private BigDecimal price;

    private PassengerBusEntity passenger;

    public TicketBusCreation() {
        //empty from framework
    }

    public TicketBusCreation(Integer seat, LocalDateTime departureTime, LocalDateTime arriveTime, BigDecimal price) {
        this.seat = seat;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.price = price;
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

    public PassengerBusEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerBusEntity passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "TicketBusCreation{" +
                "seat=" + seat +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", price=" + price +
                ", passenger=" + passenger +
                '}';
    }
}
