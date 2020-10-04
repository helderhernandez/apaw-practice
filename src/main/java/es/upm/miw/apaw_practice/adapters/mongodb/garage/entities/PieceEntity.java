package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class PieceEntity {

    @Id
    private String id;
    private String name;
    private String manufacturer;
    private Boolean inStock;
    private BigDecimal price;

    public PieceEntity() {
        //empty for framework
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
