package es.upm.miw.apaw_practice.domain.models.padel;

import java.math.BigDecimal;
import java.util.UUID;

public class Racket {
    private String id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private String weight;
    private Player player;

    public Racket() {
        //Empty for Spring
    }

    public Racket(String name, String brand, String description, BigDecimal price, String weight, Player player) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.player = player;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player playerEntity) {
        this.player = playerEntity;
    }

    @Override
    public String toString() {
        return "Racket{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", weight='" + weight + '\'' +
                ", player=" + player +
                '}';
    }
}
