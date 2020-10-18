package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class CDVehicleEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String frameNumber;
    private String brand;
    private String type;
    private Boolean unused;
    private Integer year;

    public CDVehicleEntity() {
        // Empty for framework
    }

    public static CDVehicleBuilder.Brand builder() {
        return new Builder();
    }

    public CDVehicleEntity(String frameNumber, String brand, String type, Boolean unused, Integer year) {
        this.id = UUID.randomUUID().toString();
        this.frameNumber = frameNumber;
        this.brand = brand;
        this.type = type;
        this.unused = unused;
        this.year = year;
    }

    public CDVehicleEntity(CDVehicleCreation vehicleCreation) {
        BeanUtils.copyProperties(vehicleCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
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

    public CDVehicle toVehicle() {
        CDVehicle vehicle = new CDVehicle();
        BeanUtils.copyProperties(this, vehicle);
        return vehicle;
    }

    public void fromVehicle(CDVehicle vehicle) {
        BeanUtils.copyProperties(vehicle, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CDVehicleEntity that = (CDVehicleEntity) o;
        return Objects.equals(id, that.id);
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

    public static class Builder implements CDVehicleBuilder.Brand, CDVehicleBuilder.Type, CDVehicleBuilder.Optionals {

        private CDVehicleEntity cdVehicleEntity;

        public Builder() {
            this.cdVehicleEntity = new CDVehicleEntity();
            this.cdVehicleEntity.id = UUID.randomUUID().toString();
        }

        @Override
        public CDVehicleBuilder.Type brand(String brand) {
            this.cdVehicleEntity.brand = brand;
            return this;
        }

        @Override
        public CDVehicleBuilder.Optionals type(String type) {
            this.cdVehicleEntity.type = type;
            return this;
        }

        @Override
        public CDVehicleBuilder.Optionals frameNumber(String frameNumber) {
            this.cdVehicleEntity.frameNumber = frameNumber;
            return this;
        }

        @Override
        public CDVehicleBuilder.Optionals unused(Boolean unused) {
            this.cdVehicleEntity.unused = unused;
            return this;
        }

        @Override
        public CDVehicleBuilder.Optionals year(Integer year) {
            this.cdVehicleEntity.year = year;
            return this;
        }

        @Override
        public CDVehicleEntity build() {
            return this.cdVehicleEntity;
        }
    }
}
