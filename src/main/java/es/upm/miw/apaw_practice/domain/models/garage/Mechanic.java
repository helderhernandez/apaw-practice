package es.upm.miw.apaw_practice.domain.models.garage;

import java.math.BigDecimal;

public class Mechanic {

    private String id;
    private String name;
    private String telephone;
    private String department;
    private BigDecimal pricePerHour;
    private Double numWorkedHours;
    private Boolean available;

    public Mechanic() {
        //empty for framework
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
    
}
