package es.upm.miw.apaw_practice.domain.models.transport;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;

import java.time.LocalDate;
import java.util.UUID;

public class Vehicle {

    private String id;
    private String brand;
    private String model;
    private String plate;
    private LocalDate boughtDate;
    private WorkerEntity workerEntity;

    public Vehicle() {
        //empty for framework
    }

    public Vehicle(String brand, String model, String plate, LocalDate boughtDate, WorkerEntity workerEntity) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.boughtDate = boughtDate;
        this.workerEntity = workerEntity;
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

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", boughtDate=" + boughtDate +
                ", workerEntity=" + workerEntity +
                '}';
    }
}
