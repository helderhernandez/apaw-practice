package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class VehicleTransportEntity {
    @Id
    private String id;
    private String brand;
    private String model;
    @Indexed(unique = true)
    private String plate;
    private LocalDate boughtDate;
    private WorkerEntity workerEntity;

    public VehicleTransportEntity() {
        //empty for framework
    }

    public VehicleTransportEntity(VehicleTransport vehicleTransport) {
        this.id = UUID.randomUUID().toString();
        this.brand = vehicleTransport.getBrand();
        this.model = vehicleTransport.getModel();
        this.plate = vehicleTransport.getPlate();
        this.boughtDate = vehicleTransport.getBoughtDate();
        this.workerEntity = vehicleTransport.getWorkerEntity();
    }

    public VehicleTransportEntity(String brand, String model, String plate, LocalDate boughtDate, WorkerEntity workerEntity) {
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

    public VehicleTransport toVehicle() {
        return new VehicleTransport(brand, model, plate, boughtDate, workerEntity);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((VehicleTransportEntity) obj).id));
    }

    @Override
    public String toString() {
        return "VehicleEntity{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", boughtDate=" + boughtDate +
                ", workerEntity=" + workerEntity +
                '}';
    }
}
