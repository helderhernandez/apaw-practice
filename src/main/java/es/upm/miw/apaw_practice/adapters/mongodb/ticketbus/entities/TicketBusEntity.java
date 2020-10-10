package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities;


import es.upm.miw.apaw_practice.domain.models.ticketbus.PassengerBusCreation;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBus;
import es.upm.miw.apaw_practice.domain.models.ticketbus.TicketBusCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class TicketBusEntity {

    private static final String ENTITY_REF_NAME = "TCKB";

    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private Integer seat;
    private LocalDateTime departureTime;
    private LocalDateTime arriveTime;
    private BigDecimal price;
    private LocalDateTime registrationDate;

    @DBRef
    private PassengerBusEntity passenger;

    public TicketBusEntity() {
        //empty from framework
    }

    public TicketBusEntity(Integer seat, LocalDateTime departureTime, LocalDateTime arriveTime, BigDecimal price, PassengerBusEntity passenger) {
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.seat = seat;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.price = price;
        this.passenger = passenger;
    }

    public TicketBusEntity(TicketBusCreation ticketBusCreation){
        BeanUtils.copyProperties(ticketBusCreation, this);
        this.id = UUID.randomUUID().toString();
        this.reference = GenRefEntity.getReferenceId(ENTITY_REF_NAME);
        this.registrationDate = LocalDateTime.now();
    }

    public TicketBus toTicketBus(){
        TicketBus ticketBus = new TicketBus();
        BeanUtils.copyProperties(this, ticketBus);
        ticketBus.setPassenger(this.passenger != null ? this.passenger.toPassengerBus() : null);
        return ticketBus;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(LocalDateTime arriveTime) {
        this.arriveTime = arriveTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PassengerBusEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerBusEntity passenger) {
        this.passenger = passenger;
    }

    public void changePassenger(PassengerBusCreation passengerBusCreation){
        this.setPassenger(new PassengerBusEntity(passengerBusCreation));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketBusEntity that = (TicketBusEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "TicketBusEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", seat=" + seat +
                ", departureTime=" + departureTime +
                ", arriveTime=" + arriveTime +
                ", price=" + price +
                ", registrationDate=" + registrationDate +
                ", passenger=" + passenger +
                '}';
    }
}
