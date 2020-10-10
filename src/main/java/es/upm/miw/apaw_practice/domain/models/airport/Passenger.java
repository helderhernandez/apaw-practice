package es.upm.miw.apaw_practice.domain.models.airport;

import java.util.List;

public class Passenger {

    private String id;
    private String name;
    private String surname;
    private List<Suitcase> suitcaseList;
    private List<Flight> flightList;

    public Passenger(String id, String name, String surname, List<Suitcase> suitcaseList, List<Flight> flightList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.suitcaseList = suitcaseList;
        this.flightList = flightList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", suitcaseList=" + suitcaseList +
                ", flightList=" + flightList +
                '}';
    }
}
