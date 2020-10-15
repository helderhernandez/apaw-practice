package es.upm.miw.apaw_practice.domain.models.garage;

import java.util.List;

public class Driver {

    private String id;
    private String dni;
    private String name;
    private String telephone;
    private String email;
    private Boolean garageMember;
    private List<Vehicle> vehicles;

    public Driver() {
        //empty for framework
    }

    public static DriverBuilder.Id builder() {
        return new Builder();
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

    public List<Vehicle> getVehicles() { return vehicles; }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public static class Builder implements DriverBuilder.Id, DriverBuilder.Dni, DriverBuilder.Name, DriverBuilder.Telephone, DriverBuilder.Email, DriverBuilder.GarageMember, DriverBuilder.Vehicles, DriverBuilder.Build {
        private Driver driver;

        private Builder() {
            this.driver = new Driver();
        }

        @Override
        public DriverBuilder.Dni id(String id) {
            this.driver.setId(id);
            return this;
        }

        @Override
        public DriverBuilder.Name dni(String dni) {
            this.driver.setDni(dni);
            return this;
        }

        @Override
        public DriverBuilder.Telephone name(String name) {
            this.driver.setName(name);
            return this;
        }

        @Override
        public DriverBuilder.Email telephone(String telephone) {
            this.driver.setTelephone(telephone);
            return this;
        }

        @Override
        public DriverBuilder.GarageMember email(String email) {
            this.driver.setEmail(email);
            return this;
        }

        @Override
        public DriverBuilder.Vehicles garageMember(Boolean garageMember) {
            this.driver.setGarageMember(garageMember);
            return this;
        }

        @Override
        public DriverBuilder.Build vehicles(List<Vehicle> vehicles) {
            this.driver.setVehicles(vehicles);
            return this;
        }

        @Override
        public Driver build() {
            return this.driver;
        }
    }
}
