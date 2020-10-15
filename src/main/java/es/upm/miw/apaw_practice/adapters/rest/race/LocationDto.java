package es.upm.miw.apaw_practice.adapters.rest.race;

public class LocationDto {
    private String location;

    public LocationDto() {
        // empty for framework
    }

    public LocationDto(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
                "location='" + location + '\'' +
                '}';
    }
}
