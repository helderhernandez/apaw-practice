package es.upm.miw.apaw_practice.domain.models.ticketbus;

import java.time.LocalDateTime;

public class BusTicketsDatesUpdate {
    private String reference;
    private LocalDateTime departure;
    private LocalDateTime arrive;

    public BusTicketsDatesUpdate() {
        //for framework
    }

    public BusTicketsDatesUpdate(String reference, LocalDateTime departure, LocalDateTime arrive) {
        this.reference = reference;
        this.departure = departure;
        this.arrive = arrive;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrive() {
        return arrive;
    }

    public void setArrive(LocalDateTime arrive) {
        this.arrive = arrive;
    }

    @Override
    public String toString() {
        return "BusTicketsDates{" +
                "reference='" + reference + '\'' +
                ", departure=" + departure +
                ", arrive=" + arrive +
                '}';
    }
}
