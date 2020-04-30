package es.upm.miw.apaw_practice.data.model.dtos.shop;

import java.math.BigDecimal;

public class ArticleItemDto {
    private Long barcode;
    private Integer amount;
    private BigDecimal discount;

    public ArticleItemDto() {
        //empty for framework
    }

    public ArticleItemDto(Long barcode, Integer amount, BigDecimal discount) {
        this.barcode = barcode;
        this.amount = amount;
        this.discount = discount;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "ArticleItemDto{" +
                "barcode=" + barcode +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
