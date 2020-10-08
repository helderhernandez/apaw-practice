package es.upm.miw.apaw_practice.domain.models.transittaxes;


import java.util.List;

public class Car {

    private String id;
    private String enrollment;
    private String brand;
    private List<Accident> accidents;
    private Owner owner;
    private List<Tax> transitTaxes;

    public Car() {
        //empty from framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(List<Accident> accidents) {
        this.accidents = accidents;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Tax> getTransitTaxes() {
        return transitTaxes;
    }

    public void setTransitTaxes(List<Tax> transitTaxes) {
        this.transitTaxes = transitTaxes;
    }
}
