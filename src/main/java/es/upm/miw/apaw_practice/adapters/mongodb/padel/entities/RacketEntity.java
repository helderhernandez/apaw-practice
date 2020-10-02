package es.upm.miw.apaw_practice.adapters.mongodb.padel.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Document
public class RacketEntity {
    @Id
    private String id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private String weight;
    private PlayerEntity playerEntity;

    public RacketEntity() {
        //Empty for Spring
    }

    public RacketEntity(String name, String brand, String description, BigDecimal price, String weight, PlayerEntity playerEntity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.playerEntity = playerEntity;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((PlayerEntity) obj).getId()));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "RacketEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", playerEntity=" + playerEntity +
                '}';
    }

}
