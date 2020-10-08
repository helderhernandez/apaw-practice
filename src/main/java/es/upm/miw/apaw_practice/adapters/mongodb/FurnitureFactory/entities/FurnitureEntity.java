package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities;

import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class FurnitureEntity {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private LocalDate dateOfManufacture;
    private Long serialNumber;

    public FurnitureEntity(){
        //empty for framework
    }

    public FurnitureEntity(String name,BigDecimal price,LocalDate dateOfManufacture,Long serialNumber) {
        this.id = UUID.randomUUID().toString();
        this.name=name;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.serialNumber=serialNumber;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Furniture toFurniture() {
        Furniture furniture = new Furniture();
        BeanUtils.copyProperties(this, furniture);
        return furniture;
    }

    public void fromFurniture(Furniture furniture) {
        BeanUtils.copyProperties(furniture, this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FurnitureEntity furnitureEntity = (FurnitureEntity) o;
        return Objects.equals(id, furnitureEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "FurnitureEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateOfManufacture=" + dateOfManufacture +
                ", serialNumber=" + serialNumber +
                '}';
    }

}
