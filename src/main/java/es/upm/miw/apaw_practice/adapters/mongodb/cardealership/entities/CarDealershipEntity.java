package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class CarDealershipEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private Long telephone;
    @DBRef
    private List<CDEmployeeEntity> employees;
    @DBRef
    private List<CDVehicleEntity> vehicles;
    @DBRef
    private CDOwnerEntity owner;


    public CarDealershipEntity() {
        // Empty for framework
    }

    public CarDealershipEntity(String name, String address, Long telephone, List<CDEmployeeEntity> employees, List<CDVehicleEntity> vehicles, CDOwnerEntity owner) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.employees = employees;
        this.vehicles = vehicles;
        this.owner = owner;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public List<CDEmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<CDEmployeeEntity> employees) {
        this.employees = employees;
    }

    public List<CDVehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<CDVehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public CDOwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(CDOwnerEntity owner) {
        this.owner = owner;
    }

    public CarDealership toCarDealership() {
        return new CarDealership(id, name, address, telephone);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDealershipEntity that = (CarDealershipEntity) o;
        return id.equals(that.id);
    }

    @Override
    public String toString() {
        return "CarDealershipEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
