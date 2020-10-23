package es.upm.miw.apaw_practice.adapters.rest.hospital;

public class OccupiedDto {

    private Boolean occupied;

    public Boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "OccupiedDto{" +
                "occupied=" + occupied +
                '}';
    }
}
