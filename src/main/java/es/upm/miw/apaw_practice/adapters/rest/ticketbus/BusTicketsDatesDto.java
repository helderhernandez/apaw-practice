package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import java.time.LocalDateTime;

public class BusTicketsDatesDto {

    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;

    public BusTicketsDatesDto() {
        // for framework
    }

    public BusTicketsDatesDto(LocalDateTime departureTime, LocalDateTime arriveTime) {
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
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


    @Override
    public String toString() {
        return "BusTicketsDatesDto{" +
                "departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                '}';
    }
}
