package es.upm.miw.apaw_practice.data_adapter.shop;

import java.math.BigDecimal;

public class Item {
    private Article article;
    private Integer amount;
    private BigDecimal discount;

    public Item() {
        //empty for framework
    }

    public Item(Article article, Integer amount, BigDecimal discount) {
        this.article = article;
        this.amount = amount;
        this.discount = discount;
    }

    public Article getArticle() {
        return article;
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
        return "Item{" +
                "article=" + article +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
