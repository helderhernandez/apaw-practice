package es.upm.miw.apaw_practice.domain.models.factory;

import java.math.BigDecimal;

public class ProductWholesalePriceUpdate {
    private Long serialNumber;
    private BigDecimal wholesalePrice;

    public ProductWholesalePriceUpdate() {
        //empty for framework
    }

    public ProductWholesalePriceUpdate(Long serialNumber, BigDecimal wholesalePrice) {
        this.serialNumber = serialNumber;
        this.wholesalePrice = wholesalePrice;
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
        return "ProductWholesalePriceUpdate{" +
                "serialNumber=" + serialNumber +
                ", wholesalePrice=" + wholesalePrice +
                '}';
    }
}
