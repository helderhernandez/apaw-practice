package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
public class MechanicEntity {

    @Id
    private String id;
    private String name;
    private String telephone;
    private String department;
    private BigDecimal pricePerHour;
    private Double numWorkedHours;
    private Boolean available;

    public MechanicEntity() {
        //empty for framework
    }

    public MechanicEntity(String name, String telephone, String department, BigDecimal pricePerHour, Double numWorkedHours, Boolean available) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.telephone = telephone;
        this.department = department;
        this.pricePerHour = pricePerHour;
        this.numWorkedHours = numWorkedHours;
        this.available = available;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getNumWorkedHours() {
        return numWorkedHours;
    }

    public void setNumWorkedHours(Double numWorkedHours) {
        this.numWorkedHours = numWorkedHours;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Mechanic toMechanic() {
        Mechanic mechanic = new Mechanic();
        BeanUtils.copyProperties(this, mechanic);
        return mechanic;
    }

    public void fromMechanic(Mechanic mechanic) {
        BeanUtils.copyProperties(mechanic,this);
    }

}
