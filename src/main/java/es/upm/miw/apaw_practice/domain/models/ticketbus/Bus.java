package es.upm.miw.apaw_practice.domain.models.ticketbus;


import java.time.LocalDateTime;
import java.util.List;

public class Bus {

    private String id;
    private String reference;
    private String company;
    private Integer capacity;
    private Boolean accesibility;
    private Boolean wifi;
    private LocalDateTime registrationDate;

    List<TicketBus> tickets;

    public Bus() {
        // empty from framework
    }

    public List<TicketBus> getTickets(){
        return this.tickets;
    }

    public void setTickets(List<TicketBus> tickets){
        this.tickets = tickets;
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

    @Override
    public String toString() {
        return "Bus{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", company='" + company + '\'' +
                ", capacity=" + capacity +
                ", accesibility=" + accesibility +
                ", wifi=" + wifi +
                ", registrationDate=" + registrationDate +
                ", tickets=" + tickets +
                '}';
    }
}
