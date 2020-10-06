package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Document
public class TransitTaxesEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String refTaxes;
    private String description;
    private BigDecimal price;
    private Boolean paid;

    public TransitTaxesEntity() {
        //empty from framework
    }

    public TransitTaxesEntity(String refTaxes, String description, BigDecimal price, Boolean paid) {
        this.id = UUID.randomUUID().toString();
        this.refTaxes = refTaxes;
        this.description = description;
        this.price = price;
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefTaxes() {
        return refTaxes;
    }

    public void setRefTaxes(String refTaxes) {
        this.refTaxes = refTaxes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransitTaxesEntity that = (TransitTaxesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(refTaxes, that.refTaxes) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(paid, that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refTaxes, description, price, paid);
    }

    @Override
    public String toString() {
        return "TransitTaxesEntity{" +
                "id='" + id + '\'' +
                ", refTaxes='" + refTaxes + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", paid=" + paid +
                '}';
    }
}
