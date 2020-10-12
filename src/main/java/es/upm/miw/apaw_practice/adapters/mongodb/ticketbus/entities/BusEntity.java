package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Bus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.BusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class BusEntity {

    private static final String ENTITY_REF_NAME = "BS";

    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String company;
    private Integer capacity;
    private Boolean accesibility;
    private Boolean wifi;
    private LocalDateTime registrationDate;

    @DBRef
    private List<TicketBusEntity> tickets;

    @DBRef
    private List<JourneyEntity> journeys;

    public BusEntity() {
        // empty from framework
    }

    public BusEntity(String company, Integer capacity, Boolean accesibility, Boolean wifi, List<TicketBusEntity> tickets, List<JourneyEntity> journeys) {
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.capacity = capacity;
        this.company = company;
        this.accesibility = accesibility;
        this.wifi = wifi;
        this.tickets = tickets;
        this.journeys = journeys;
    }

    public BusEntity(BusCreation busCreation) {
        BeanUtils.copyProperties(busCreation, this);
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.registrationDate = LocalDateTime.now();
    }

    public Bus toBus() {
        Bus bus = new Bus();
        BeanUtils.copyProperties(this, bus);
        List<TicketBus> ticketsAux = this.tickets.stream()
                .map(TicketBusEntity::toTicketBus)
                .collect(Collectors.toList());
        bus.setTickets(ticketsAux);
        return bus;
    }

    public String getId() {
        return this.id;
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

    public Boolean getAccesibility() {
        return accesibility;
    }

    public void setAccesibility(Boolean accesibility) {
        this.accesibility = accesibility;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public List<TicketBusEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketBusEntity> tickets) {
        this.tickets = tickets;
    }

    public List<JourneyEntity> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<JourneyEntity> journeys) {
        this.journeys = journeys;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusEntity busEntity = (BusEntity) o;
        return id.equals(busEntity.id) &&
                reference.equals(busEntity.reference) &&
                capacity.equals(busEntity.capacity) &&
                company.equals(busEntity.company);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "BusEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", capacity='" + capacity + '\'' +
                ", company='" + company + '\'' +
                ", accesibility=" + accesibility +
                ", wifi=" + wifi +
                ", tickets=" + tickets +
                ", journeys=" + journeys +
                '}';
    }

}
