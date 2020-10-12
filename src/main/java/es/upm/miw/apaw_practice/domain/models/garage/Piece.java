package es.upm.miw.apaw_practice.domain.models.garage;

import java.math.BigDecimal;

public class Piece {

    private String barcode;
    private String name;
    private Boolean inStock;
    private BigDecimal price;

    public Piece() {
        // empty for framework
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
