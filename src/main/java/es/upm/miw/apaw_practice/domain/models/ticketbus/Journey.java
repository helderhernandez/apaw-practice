package es.upm.miw.apaw_practice.domain.models.ticketbus;


public class Journey {

    private String id;
    private String departure;
    private String arrive;
    private Integer numStops;

    public Journey() {
        //empty from framework
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
        return "Journey{" +
                "id='" + id + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", numStops=" + numStops +
                '}';
    }
}
