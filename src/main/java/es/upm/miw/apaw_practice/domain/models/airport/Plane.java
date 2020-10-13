package es.upm.miw.apaw_practice.domain.models.airport;

public class Plane {

    private String id;
    private String model;
    private Integer capacity;
    private Boolean complete;
    private String licensePlate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static PlaneBuilders.Id builder() {
        return new Builder();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", complete=" + complete +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public static class Builder implements PlaneBuilders.Id, PlaneBuilders.Model, PlaneBuilders.Capacity, PlaneBuilders.Complete, PlaneBuilders.LicensePlate, PlaneBuilders.Build{

        private Plane plane;

        public Builder() {
            plane = new Plane();
        }
        @Override
        public PlaneBuilders.Model id(String id) {
            plane.setId(id);
            return this;
        }

        @Override
        public PlaneBuilders.Capacity model(String model) {
            plane.setModel(model);
            return this;
        }

        @Override
        public PlaneBuilders.Complete capacity(Integer capacity) {
            plane.setCapacity(capacity);
            return this;
        }

        @Override
        public PlaneBuilders.LicensePlate complete(Boolean complete) {
            plane.setComplete(complete);
            return this;
        }

        @Override
        public PlaneBuilders.Build licensePlate(String licensePlate) {
            plane.setLicensePlate(licensePlate);
            return this;
        }

        @Override
        public Plane build() {
            return plane;
        }
    }
}
