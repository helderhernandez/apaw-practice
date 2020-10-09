package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CDVehicleEntity {
    @Id
    private String id;
    private String brand;
    private String type;
    private Boolean unused;
    private Integer year;

    public CDVehicleEntity() {
        // Empty for framework
    }

    public CDVehicleEntity(String brand, String type, Boolean unused, Integer year) {
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

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CDVehicleEntity{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", unused=" + unused +
                ", year=" + year +
                '}';
    }
}
