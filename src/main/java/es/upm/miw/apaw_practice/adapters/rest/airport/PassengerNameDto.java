package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;

public class PassengerNameDto {

    private String name;

    public PassengerNameDto() {

    }

    public PassengerNameDto(String name) {
        this.name = name;
    }

    public PassengerNameDto(Passenger passenger) {
        this.name = passenger.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PassengerNameDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
