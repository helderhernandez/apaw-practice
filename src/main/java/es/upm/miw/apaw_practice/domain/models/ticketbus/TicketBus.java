package es.upm.miw.apaw_practice.domain.models.ticketbus;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TicketBus {

    private String id;
    private Integer seat;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private BigDecimal price;


    private LocalDateTime registrationDate;


    public TicketBus() {
        //empty from framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TicketBus{" +
                "id='" + id + '\'' +
                ", seat=" + seat +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", price=" + price +
                '}';
    }
}
