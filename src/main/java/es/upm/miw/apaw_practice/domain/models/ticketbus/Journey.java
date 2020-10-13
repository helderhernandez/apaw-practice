package es.upm.miw.apaw_practice.domain.models.ticketbus;


import java.time.LocalDateTime;

public class Journey {

    private String reference;
    private String departure;
    private String arrive;
    private Integer numStops;
    private LocalDateTime registrationDate;

    public Journey() {
        //empty from framework
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public Integer getNumStops() {
        return numStops;
    }

    public void setNumStops(Integer numStops) {
        this.numStops = numStops;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "reference='" + reference + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", numStops=" + numStops +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
