package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Document
public class SurgeryEntity {
    @Id
    private String id;
    private String type;
    private BigDecimal price;
    @DBRef
    private List<VeterinaryEntity> veterinarians;
    @DBRef
    private List<AnimalEntity> animals;

    public SurgeryEntity(String id, String type, BigDecimal price, List<VeterinaryEntity> veterinarians,
                         List<AnimalEntity> animals){
        this.id = id;
        this.type = type;
        this.price = price;
        this.veterinarians = veterinarians;
        this.animals = animals;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<VeterinaryEntity> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<VeterinaryEntity> veterinarians) {
        this.veterinarians = veterinarians;
    }

    public List<AnimalEntity> getAnimals() {
        return animals;
    }

    public void setAnimals(List<AnimalEntity> animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurgeryEntity that = (SurgeryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(price, that.price) &&
                Objects.equals(veterinarians, that.veterinarians) &&
                Objects.equals(animals, that.animals);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "SurgeryEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", veterinarians=" + veterinarians +
                ", animals=" + animals +
                '}';
    }
}
