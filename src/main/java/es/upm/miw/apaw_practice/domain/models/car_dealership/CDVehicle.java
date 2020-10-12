package es.upm.miw.apaw_practice.domain.models.car_dealership;

public class CDVehicle {
    private String id;
    private String brand;
    private String type;
    private Boolean unused;
    private Integer year;

    public CDVehicle() {
        // Empty for framework
    }

    public CDVehicle(String id, String brand, String type, Boolean unused, Integer year) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.unused = unused;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getUnused() {
        return unused;
    }

    public void setUnused(Boolean unused) {
        this.unused = unused;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
