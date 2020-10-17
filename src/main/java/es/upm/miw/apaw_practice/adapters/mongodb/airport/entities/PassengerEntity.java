package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import es.upm.miw.apaw_practice.domain.models.airport.Suitcase;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class PassengerEntity {

    @Id
    private String id;
    private String name;
    private String surname;
    private List<SuitcaseEntity> suitcaseEntities;
    @DBRef
    private List<FlightEntity> flightEntities;

    public PassengerEntity() {
        //empty for framework
    }

    public PassengerEntity(String name, String surname, List<SuitcaseEntity> suitcaseEntities, List<FlightEntity> flightEntities) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.suitcaseEntities = suitcaseEntities;
        this.flightEntities = flightEntities;
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

    public List<SuitcaseEntity> getSuitcaseEntities() {
        return suitcaseEntities;
    }

    public void setSuitcaseEntities(List<SuitcaseEntity> suitcaseEntities) {
        this.suitcaseEntities = suitcaseEntities;
    }

    public List<FlightEntity> getFlightEntities() {
        return flightEntities;
    }

    public void setFlightEntities(List<FlightEntity> flightEntities) {
        this.flightEntities = flightEntities;
    }

    public Passenger toPassenger() {
        List<Flight> flightList = this.flightEntities.stream()
                .map(FlightEntity::toFlight)
                .collect(Collectors.toList());
        List<Suitcase> suitcaseList = this.suitcaseEntities.stream()
                .map(SuitcaseEntity::toSuitCase)
                .collect(Collectors.toList());

        return new Passenger(name, surname, suitcaseList, flightList);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerEntity that = (PassengerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(suitcaseEntities, that.suitcaseEntities) &&
                Objects.equals(flightEntities, that.flightEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, suitcaseEntities, flightEntities);
    }

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", suitcaseEntities=" + suitcaseEntities +
                ", flightEntities=" + flightEntities +
                '}';
    }
}
