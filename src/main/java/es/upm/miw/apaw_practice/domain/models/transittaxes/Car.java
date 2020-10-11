package es.upm.miw.apaw_practice.domain.models.transittaxes;


import java.util.List;

public class Car {

    private String enrollment;
    private String brand;
    private List<String> refAccidents;
    private String dniOwner;
    private List<String> refTaxes;

    public Car() {
        //empty from framework
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

    public List<String> getRefAccidents() {
        return refAccidents;
    }

    public void setRefAccidents(List<String> refAccidents) {
        this.refAccidents = refAccidents;
    }

    public String getDniOwner() {
        return dniOwner;
    }

    public void setDniOwner(String dniOwner) {
        this.dniOwner = dniOwner;
    }

    public List<String> getRefTaxes() {
        return refTaxes;
    }

    public void setRefTaxes(List<String> refTaxes) {
        this.refTaxes = refTaxes;
    }
}
