package es.upm.miw.apaw_practice.adapters.mongodb.airport.entities;

import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class PlaneEntity {

    @Id
    private String id;
    private String model;
    private Integer capacity;
    private Boolean complete;
    @Indexed(unique = true)
    private String licensePlate;

    public PlaneEntity() {
        //empty from framework
    }

    public PlaneEntity(String model, Integer capacity, Boolean complete, String licensePlate) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.capacity = capacity;
        this.complete = complete;
        this.licensePlate = licensePlate;
    }

    public PlaneEntity(PlaneCreation planeCreation) {
        BeanUtils.copyProperties(planeCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Plane toPlane() {
        Plane plane = new Plane();
        BeanUtils.copyProperties(this, plane);
        return plane;
    }
    @Override
    public String toString() {
        return "PlaneEntity{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", complete=" + complete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneEntity that = (PlaneEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(model, that.model) &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(complete, that.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, capacity, complete);
    }

}
