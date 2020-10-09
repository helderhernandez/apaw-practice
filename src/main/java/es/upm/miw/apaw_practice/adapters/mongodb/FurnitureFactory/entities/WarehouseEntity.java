package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Document
public class WarehouseEntity {
    @Id
    private String id;
    private String name;
    private String area;
    private Boolean isActive;
    @DBRef
    private List<StaffEntity> staffEntities;
    @DBRef
    private List<AddressEntity> addressEntity;
    @DBRef
    private List<FurnitureEntity> furnitureEntity;


    public WarehouseEntity(){
        //empty for framework
    }

    public List<FurnitureEntity> getFurnitureEntity() {
        return furnitureEntity;
    }

    public void setFurnitureEntity(List<FurnitureEntity> furnitureEntity) {
        this.furnitureEntity = furnitureEntity;
    }

    public WarehouseEntity(String name, String area, Boolean isActive, List<StaffEntity> staffEntities, List<AddressEntity> addressEntity, List<FurnitureEntity> furnitureEntity) {
        this.id = UUID.randomUUID().toString();
        this.name=name;
        this.area = area;
        this.isActive = isActive;
        this.staffEntities = staffEntities;
        this.addressEntity=addressEntity;
        this.furnitureEntity=furnitureEntity;
    }

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
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<StaffEntity> getEmployeeEntity() {
        return staffEntities;
    }

    public void setEmployeeEntity(List<StaffEntity> workerEntity) {
        this.staffEntities = workerEntity;
    }

    public List<AddressEntity> getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(List<AddressEntity> addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseEntity that = (WarehouseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WarehouseEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", isActive=" + isActive +
                ", employeeEntity=" + staffEntities +
                ", addressEntity=" + addressEntity +
                ", furnitureEntity=" + furnitureEntity +
                '}';
    }
}
