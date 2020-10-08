package es.upm.miw.apaw_practice.domain.models.ticketbus;


public class JourneyCreation {

    private String departure;
    private String arrive;
    private Integer numStops;


    public JourneyCreation() {
        //empty from framework
    }

    public JourneyCreation(String departure, String arrive, Integer numStops) {
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
        return this.arrive;
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
