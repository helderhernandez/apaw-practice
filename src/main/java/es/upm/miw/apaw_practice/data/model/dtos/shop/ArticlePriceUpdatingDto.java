package es.upm.miw.apaw_practice.data.model.dtos.shop;

import java.math.BigDecimal;

public class ArticlePriceUpdatingDto {

    private Long barcode;
    private BigDecimal price;

    public ArticlePriceUpdatingDto() {
        //empty for framework
    }

    public ArticlePriceUpdatingDto(Long barcode, BigDecimal price) {
        this.barcode = barcode;
        this.price = price;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ArticlePriceUpdatingDto{" +
                "barcode=" + barcode +
                ", price=" + price +
                '}';
    }
}
