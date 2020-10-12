package es.upm.miw.apaw_practice.adapters.rest.transport;

public class DistinctModelVehicleDto {
    private String model;

    public DistinctModelVehicleDto() {
        //Empty for framework
    }

    public DistinctModelVehicleDto(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "DistinctModelVehicleDto{" +
                "model='" + model + '\'' +
                '}';
    }
}
