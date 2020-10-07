package es.upm.miw.apaw_practice.adapters.rest.airport;

public class CapacityDto {

    private Integer capacity;


    public CapacityDto() {

    }

    public CapacityDto(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "CapacityDto{" +
                "capacity='" + capacity + '\'' +
                '}';
    }
}
