package es.upm.miw.apaw_practice.domain.models.airport;

import java.util.List;

public class Passenger {

    private String name;
    private String surname;
    private List<Suitcase> suitcaseList;
    private List<Flight> flightList;

    public Passenger(String name, String surname, List<Suitcase> suitcaseList, List<Flight> flightList) {
        this.name = name;
        this.surname = surname;
        this.suitcaseList = suitcaseList;
        this.flightList = flightList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Suitcase> getSuitcaseList() {
        return suitcaseList;
    }

    public void setSuitcaseList(List<Suitcase> suitcaseList) {
        this.suitcaseList = suitcaseList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

}
