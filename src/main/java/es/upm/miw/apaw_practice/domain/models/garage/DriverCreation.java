package es.upm.miw.apaw_practice.domain.models.garage;

import java.util.List;

public class DriverCreation {

    private String dni;
    private String name;
    private String telephone;
    private String email;
    private Boolean garageMember;
    private List<VehicleCreation> vehicleCreations;

    public DriverCreation() {
        // empty for framework
    }

    public DriverCreation(String dni, String name, String telephone, String email, Boolean garageMember, List<VehicleCreation> vehicleCreations) {
        this.dni = dni;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.garageMember = garageMember;
        this.vehicleCreations = vehicleCreations;
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

    public List<VehicleCreation> getVehicleCreations() {
        return vehicleCreations;
    }

    public void setVehicleCreations(List<VehicleCreation> vehicleCreations) {
        this.vehicleCreations = vehicleCreations;
    }

}
