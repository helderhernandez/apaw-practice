package es.upm.miw.apaw_practice.data.shop.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Document
public class Article {
    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    private String description;
    private LocalDate registrationDate;
    private BigDecimal price;
    private String provider;

    public Article() {
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDate.now();
    }

    public Article(String code, String description, BigDecimal price, String provider) {
        this();
        this.code = code;
        this.description = description;
        this.price = price;
        this.provider = provider;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((Article) obj).id));
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                ", price=" + price +
                ", provider='" + provider + '\'' +
                '}';
    }
}
