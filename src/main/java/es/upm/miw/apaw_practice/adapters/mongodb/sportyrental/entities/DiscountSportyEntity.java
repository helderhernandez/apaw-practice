package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities;

import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.DiscountSporty;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class DiscountSportyEntity {

    @Id
    private String idDiscount;
    private String description;
    private Double percentage;

    public DiscountSportyEntity() {
        //empty for framework
    }

    public DiscountSportyEntity(String idDiscount, String description, Double percentage) {
        this.idDiscount = idDiscount;
        this.description = description;
        this.percentage = percentage;
    }

    public DiscountSportyEntity(DiscountCreationSporty discountCreationSporty) {
        BeanUtils.copyProperties(discountCreationSporty, this);
        this.idDiscount = UUID.randomUUID().toString();
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public DiscountSporty convertToDiscountSporty() {
        return new DiscountSporty(this.idDiscount, this.description, this.percentage);
    }

    @Override
    public String toString() {
        return "DiscountSportyEntity{" +
                "idDiscount='" + idDiscount + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
