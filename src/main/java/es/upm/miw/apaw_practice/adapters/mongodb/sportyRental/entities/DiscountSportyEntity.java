package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DiscountSportyEntity {

    @Id
    private String idDiscount;
    private String description;
    private Double percentage;

    public DiscountSportyEntity() {
    }

    public DiscountSportyEntity(String idDiscount, String description, Double percentage) {
        this.idDiscount = idDiscount;
        this.description = description;
        this.percentage = percentage;
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

    @Override
    public String toString() {
        return "DiscountSportyEntity{" +
                "idDiscount='" + idDiscount + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
