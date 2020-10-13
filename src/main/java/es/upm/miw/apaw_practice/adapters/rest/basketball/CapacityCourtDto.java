package es.upm.miw.apaw_practice.adapters.rest.basketball;

public class CapacityCourtDto {
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "CapacityCourtDto{" +
                "capacity='" + capacity + '\'' +
                '}';
    }
}
