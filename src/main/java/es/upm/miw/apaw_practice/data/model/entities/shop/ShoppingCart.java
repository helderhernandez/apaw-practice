package es.upm.miw.apaw_practice.data.model.entities.shop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class ShoppingCart {
    @Id
    private String id;
    private LocalDateTime creationDate;
    private List<ArticleItem> articleItems;
    private String user;
    private String address;

    public ShoppingCart() {
        this.id = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
    }

    public ShoppingCart(List<ArticleItem> articleItems, String user, String address) {
        this();
        this.articleItems = articleItems;
        this.user = user;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<ArticleItem> getArticleItems() {
        return articleItems;
    }

    public void setArticleItems(List<ArticleItem> articleItems) {
        this.articleItems = articleItems;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal total() {
        return this.articleItems.stream()
                .map(articleItem -> {
                            BigDecimal discount = BigDecimal.ONE
                                    .subtract(articleItem.getDiscount()
                                            .divide(new BigDecimal(100), 4, RoundingMode.HALF_UP));
                            return articleItem.getArticle().getPrice()
                                    .multiply(BigDecimal.valueOf(articleItem.getAmount())
                                            .multiply(discount)
                                    );
                        }
                ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((ShoppingCart) obj).id));
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id='" + id + '\'' +
                ", creationDate=" + creationDate +
                ", articleItems=" + articleItems +
                ", user='" + user + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
