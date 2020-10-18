package es.upm.miw.apaw_practice.domain.models.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import java.util.List;
import java.util.Objects;

public class Warehouse {
    private String id;
    private String name;
    private String area;
    private Boolean active;
    private List<StaffEntity> staffEntities;
    private List<AddressEntity> addressEntity;

    @Override
    public String toString() {
        return "Warehouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", active=" + active +
                ", staffEntities=" + staffEntities +
                ", addressEntity=" + addressEntity +
                ", furnitureEntity=" + furnitureEntity +
                '}';
    }

    public List<StaffEntity> getStaffEntities() {
        return staffEntities;
    }

    public void setStaffEntities(List<StaffEntity> staffEntities) {
        this.staffEntities = staffEntities;
    }

    public List<AddressEntity> getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(List<AddressEntity> addressEntity) {
        this.addressEntity = addressEntity;
    }

    public List<FurnitureEntity> getFurnitureEntity() {
        return furnitureEntity;
    }

    public void setFurnitureEntity(List<FurnitureEntity> furnitureEntity) {
        this.furnitureEntity = furnitureEntity;
    }

    private List<FurnitureEntity> furnitureEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(id, warehouse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
