package es.upm.miw.apaw_practice.domain.models.factory;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;

import java.time.LocalDate;
import java.util.List;

public class Machine {
    private List<EmployeeEntity> employeeEntities;
    private List<ProductEntity> productEntities;
    private String id;
    private Long serialNumber;
    private Boolean isActive;
    private LocalDate lastInspection;

    public Machine() {
        // empty for framework
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(LocalDate lastInspection) {
        this.lastInspection = lastInspection;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id='" + id + '\'' +
                ", serialNumber=" + serialNumber +
                ", isActive=" + isActive +
                ", lastInspection=" + lastInspection +
                '}';
    }
}
