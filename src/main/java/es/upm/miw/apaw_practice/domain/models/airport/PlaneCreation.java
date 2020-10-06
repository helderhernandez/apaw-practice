package es.upm.miw.apaw_practice.domain.models.airport;

public class PlaneCreation {

    private String model;
    private Integer capacity;
    private Boolean complete;
    private String licensePlate;

    public PlaneCreation() {
        //empty for framework
    }

    public PlaneCreation(String model, Integer capacity, Boolean complete, String licensePlate) {
        this.model = model;
        this.capacity = capacity;
        this.complete = complete;
        this.licensePlate = licensePlate;
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
        return "PlaneCreation{" +
                "model='" + model + '\'' +
                ", capacity=" + capacity +
                ", complete=" + complete +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
