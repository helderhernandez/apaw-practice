package es.upm.miw.apaw_practice.domain.models.ticketbus;

import java.time.LocalDateTime;
import java.util.List;

public class BusCreation {

    private String id;
    private String reference;
    private String company;
    private Integer capacity;
    private Boolean accesibility;
    private Boolean wifi;
    private LocalDateTime registrationDate;
    private List<JourneyCreate> journeys;
    private List<TicketBusCreation> tickets;

    public BusCreation() {
        // empty from framework
    }

    public BusCreation(String reference, String company, Integer capacity, Boolean accesibility, Boolean wifi) {
        this.reference = reference;
        this.company = company;
        this.capacity = capacity;
        this.accesibility = accesibility;
        this.wifi = wifi;
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<JourneyCreate> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<JourneyCreate> journeys) {
        this.journeys = journeys;
    }

    public List<TicketBusCreation> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketBusCreation> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "BusCreation{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                ", accesibility=" + accesibility +
                ", wifi=" + wifi +
                ", registrationDate=" + registrationDate +
                ", journeys=" + journeys +
                ", tickets=" + tickets +
                '}';
    }
}
