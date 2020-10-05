package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class VehicleEntity {
    @Id
    private String id;
    private String brand;
    private String model;
    private String plate;
    private LocalDate boughtDate;

    public VehicleEntity() {
        //empty for framework
    }

    public VehicleEntity(String brand, String model, String plate, LocalDate boughtDate) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.boughtDate = boughtDate;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDate getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(LocalDate boughtDate) {
        this.boughtDate = boughtDate;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((VehicleEntity) obj).id));
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", boughtDate=" + boughtDate +
                '}';
    }
}
