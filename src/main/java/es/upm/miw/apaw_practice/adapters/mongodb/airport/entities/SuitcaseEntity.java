package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Suitcase;

import java.util.Objects;

public class SuitcaseEntity {

    private String color;
    private Double size;
    private String manufacturer;

    public SuitcaseEntity() {
        //empty for framework
    }

    public SuitcaseEntity(String color, Double size, String manufacturer) {
        this.color = color;
        this.size = size;
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Suitcase toSuitCase() {
        return new Suitcase(color, size, manufacturer);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuitcaseEntity that = (SuitcaseEntity) o;
        return Objects.equals(color, that.color) &&
                Objects.equals(size, that.size) &&
                Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, manufacturer);
    }

    @Override
    public String toString() {
        return "SuitcaseEntity{" +
                "color='" + color + '\'' +
                ", size=" + size +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
