package es.upm.miw.apaw_practice.domain.models.ticketbus;

import org.springframework.data.annotation.Id;


public class JourneyCreate {
    @Id
    private String id;
    private String departure;
    private String arrive;
    private Integer numStops;


    public JourneyCreate() {
        //empty from framework
    }

    public JourneyCreate(String departure, String arrive, Integer numStops) {
        this.departure = departure;
        this.arrive = arrive;
        this.numStops = numStops;
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

    @Override
    public String toString() {
        return "JourneyCreate{" +
                "departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", numStops=" + numStops +
                '}';
    }
}
