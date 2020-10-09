package es.upm.miw.apaw_practice.adapters.mongodb.factory.entities;

import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

public class MachineEntity {

    @Id
    private String id;
    @DBRef
    private List<EmployeeEntity> employeeEntities;
    @DBRef
    private List<ProductEntity> productEntities;
    @Indexed(unique = true)
    private Long serialNumber;
    private Boolean active;
    private LocalDate lastInspection;

    public MachineEntity() {
        // empty for framework
    }

    public MachineEntity(List<EmployeeEntity> employeeEntities, List<ProductEntity> productEntities, Long serialNumber, Boolean active, LocalDate lastInspection) {
        this.employeeEntities = employeeEntities;
        this.productEntities = productEntities;
        this.serialNumber = serialNumber;
        this.active = active;
        this.lastInspection = lastInspection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(LocalDate lastInspection) {
        this.lastInspection = lastInspection;
    }

    public Machine toMachine() {
        Machine machine = new Machine();
        BeanUtils.copyProperties(this, machine);
        return machine;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (serialNumber.equals(((MachineEntity) obj).serialNumber));
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "MachineEntity{" +
                "id='" + id + '\'' +
                ", employeeEntities=" + employeeEntities +
                ", productEntities=" + productEntities +
                ", serialNumber=" + serialNumber +
                ", active=" + active +
                ", lastInspection=" + lastInspection +
                '}';
    }
}
