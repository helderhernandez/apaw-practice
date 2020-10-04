package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class DriverEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String dni;
    private String name;
    private String telephone;
    private String email;
    private Boolean garageMember;
    private List<VehicleEntity> vehicleEntities;

    public DriverEntity(){
        //empty for framework
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

}
