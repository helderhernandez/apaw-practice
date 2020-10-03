package es.upm.miw.apaw_practice.domain.models.factory;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String itemReference;
    private Long serialNumber;
    private BigDecimal wholesalePrice;

    public Product() {
        // empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemReference() {
        return itemReference;
    }

    public void setItemReference(String itemReference) {
        this.itemReference = itemReference;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", itemReference='" + itemReference + '\'' +
                ", serialNumber=" + serialNumber +
                ", wholesalePrice=" + wholesalePrice +
                '}';
    }
}
