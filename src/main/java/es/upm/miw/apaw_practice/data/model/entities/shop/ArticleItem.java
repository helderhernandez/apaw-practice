package es.upm.miw.apaw_practice.data.model.entities.shop;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

public class ArticleItem {
    @DBRef
    private Article article;
    private Integer amount;
    private BigDecimal discount;

    public ArticleItem() {
        //empty for framework
    }

    public ArticleItem(Article article, Integer amount, BigDecimal discount) {
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
        return "ArticleItemDto{" +
                "article=" + article +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}
