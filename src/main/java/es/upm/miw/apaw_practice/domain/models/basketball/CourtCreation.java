package es.upm.miw.apaw_practice.domain.models.basketball;

public class CourtCreation {
    private String name;
    private Integer capacity;

    public CourtCreation() {
        //Empty constructor for the framework
    }

    public CourtCreation(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

}
