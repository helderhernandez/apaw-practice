package es.upm.miw.apaw_practice.domain.models.ticketbus;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketBus {

    private String reference;
    private Integer seat;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private BigDecimal price;
    private LocalDateTime registrationDate;

    private PassengerBus passenger;


    public TicketBus() {
        //empty from framework
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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


    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public PassengerBus getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerBus passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "TicketBus{" +
                "reference='" + reference + '\'' +
                ", seat=" + seat +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", price=" + price +
                '}';
    }
}
