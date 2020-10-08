package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Document
public class TaxEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String refTax;
    private String description;
    private BigDecimal price;
    private Boolean paid;

    public TaxEntity() {
        //empty from framework
    }

    public TaxEntity(String refTax, String description, BigDecimal price, Boolean paid) {
        this.id = UUID.randomUUID().toString();
        this.refTax = refTax;
        this.description = description;
        this.price = price;
        this.paid = paid;
    }

    public TaxEntity(TaxCreation taxCreation) {
        BeanUtils.copyProperties(taxCreation, this);
        this.id = UUID.randomUUID().toString();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefTax() {
        return refTax;
    }

    public void setRefTax(String refTax) {
        this.refTax = refTax;
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
        TaxEntity that = (TaxEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(refTax, that.refTax) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(paid, that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, refTax, description, price, paid);
    }

    @Override
    public String toString() {
        return "TransitTaxesEntity{" +
                "id='" + id + '\'' +
                ", refTaxes='" + refTax + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", paid=" + paid +
                '}';
    }

    public Tax toTax() {
        Tax tax = new Tax();
        BeanUtils.copyProperties(this, tax);
        return tax;
    }
}
