package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import es.upm.miw.apaw_practice.domain.models.ticketbus.JourneyCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class JourneyEntity {

    private static final String ENTITY_REF_NAME = "JRNY";

    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String departure;
    private String arrive;
    private Integer numStops;
    private LocalDateTime registrationDate;

    public JourneyEntity() {
        //empty from framework
    }

    public JourneyEntity(String departure, String arrive, Integer numStops) {
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.departure = departure;
        this.arrive = arrive;
        this.numStops = numStops;
    }

    public JourneyEntity(JourneyCreation journeyCreation) {
        BeanUtils.copyProperties(journeyCreation, this);
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.registrationDate = LocalDateTime.now();
    }

    public Journey toJourney() {
        Journey journey = new Journey();
        BeanUtils.copyProperties(this, journey);
        return journey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JourneyEntity that = (JourneyEntity) o;
        return id.equals(that.id) &&
                departure.equals(that.departure) &&
                arrive.equals(that.arrive) &&
                numStops.equals(that.numStops);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "JourneyEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", departure='" + departure + '\'' +
                ", arrive='" + arrive + '\'' +
                ", numStops=" + numStops +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
