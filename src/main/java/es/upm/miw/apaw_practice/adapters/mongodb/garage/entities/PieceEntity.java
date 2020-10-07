package es.upm.miw.apaw_practice.adapters.mongodb.garage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.util.UUID;

public class PieceEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String barcode;
    private String name;
    private String manufacturer;
    private Boolean inStock;
    private BigDecimal price;

    public PieceEntity() {
        //empty for framework
    }

    public PieceEntity(String barcode, String name, String manufacturer, Boolean inStock, BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.barcode = barcode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.inStock = inStock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
