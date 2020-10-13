package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class DriverEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String telephone;
    private String email;
    private Boolean garageMember;
    @DBRef
    private List<VehicleEntity> vehicleEntities;

    public DriverEntity() {
        //empty for framework
    }

    public DriverEntity(String dni, String name, String telephone, String email, Boolean garageMember, List<VehicleEntity> vehicleEntities) {
        this.id = UUID.randomUUID().toString();
        this.dni = dni;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.garageMember = garageMember;
        this.vehicleEntities = vehicleEntities;
    }

    public DriverEntity(DriverCreation driverCreation) {
        this.id = UUID.randomUUID().toString();
        this.dni = driverCreation.getDni();
        this.name = driverCreation.getName();
        this.telephone = driverCreation.getTelephone();
        this.email = driverCreation.getEmail();
        this.garageMember = driverCreation.getGarageMember();
        this.vehicleEntities = driverCreation.getVehicleCreations().stream()
                                                    .map(VehicleEntity::new)
                                                    .collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGarageMember() {
        return garageMember;
    }

    public void setGarageMember(Boolean garageMember) {
        this.garageMember = garageMember;
    }

    public List<VehicleEntity> getVehicleEntities() {
        return vehicleEntities;
    }

    public void setVehicleEntities(List<VehicleEntity> vehicleEntities) {
        this.vehicleEntities = vehicleEntities;
    }

    public Driver toDriver() {
        Driver driver = new Driver();
        BeanUtils.copyProperties(this, driver);
        return driver;
    }

    public void fromDriver(Driver driver) {
        BeanUtils.copyProperties(driver, this);
    }

}
