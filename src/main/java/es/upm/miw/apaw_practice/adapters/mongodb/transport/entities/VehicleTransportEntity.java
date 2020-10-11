package es.upm.miw.apaw_practice.adapters.mongodb.transport.entities;

import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import org.springframework.beans.BeanUtils;
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

    public VehicleTransportEntity(String plate) {
        this.id = UUID.randomUUID().toString();
        this.plate = plate;
    }

    public VehicleTransportEntity(VehicleTransport vehicleTransport) {
        BeanUtils.copyProperties(vehicleTransport, this);
    }

    public static VehicleTransportEntity.VehicleTransportBuilder builder(String plate) {
        return new VehicleTransportEntity.VehicleTransportBuilder(plate);
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

    public VehicleTransport toVehicleTransport() {
        VehicleTransport vehicleTransport = new VehicleTransport();
        BeanUtils.copyProperties(this, vehicleTransport);
        return vehicleTransport;
    }

    public static class VehicleTransportBuilder {
        private final VehicleTransportEntity vehicleTransportEntity;

        private VehicleTransportBuilder(String plate) {
            this.vehicleTransportEntity = new VehicleTransportEntity(plate);
        }

        public VehicleTransportBuilder brand(String brand) {
            this.vehicleTransportEntity.brand = brand;
            return this;
        }

        public VehicleTransportBuilder model(String model) {
            this.vehicleTransportEntity.model = model;
            return this;
        }

        public VehicleTransportBuilder boughtDate(LocalDate boughtDate) {
            this.vehicleTransportEntity.boughtDate = boughtDate;
            return this;
        }

        public VehicleTransportBuilder workerEntity(WorkerEntity workerEntity) {
            this.vehicleTransportEntity.workerEntity = workerEntity;
            return this;
        }

        public VehicleTransportEntity build() {
            return this.vehicleTransportEntity;
        }
    }
}
