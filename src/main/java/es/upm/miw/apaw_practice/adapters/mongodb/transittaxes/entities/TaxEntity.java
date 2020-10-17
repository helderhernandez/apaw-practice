package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
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

    public TaxEntity(Tax tax) {
        BeanUtils.copyProperties(tax, this);
        this.id = UUID.randomUUID().toString();
    }

    public static TaxBuilders.IdTax builder() {
        return new Builder();
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

    public Tax toTax() {
        Tax tax = new Tax();
        BeanUtils.copyProperties(this, tax);
        return tax;
    }

    public static class Builder implements TaxBuilders.IdTax, TaxBuilders.RefTax, TaxBuilders.Price, TaxBuilders.Optatives {

        private TaxEntity taxEntity;

        public Builder() {
            this.taxEntity = new TaxEntity();
        }

        @Override
        public TaxBuilders.RefTax idTax() {
            this.taxEntity.id = UUID.randomUUID().toString();
            return this;
        }

        @Override
        public TaxBuilders.Price refTax(String refTax) {
            this.taxEntity.refTax = refTax;
            return this;
        }

        @Override
        public TaxBuilders.Optatives price(BigDecimal price) {
            this.taxEntity.price = price;
            return this;
        }

        @Override
        public TaxBuilders.Optatives description(String description) {
            this.taxEntity.description = description;
            return this;
        }

        @Override
        public TaxBuilders.Optatives paid(Boolean paid) {
            this.taxEntity.paid = paid;
            return this;
        }

        @Override
        public TaxEntity build() {
            return taxEntity;
        }
    }
}
