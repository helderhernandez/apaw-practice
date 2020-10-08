package es.upm.miw.apaw_practice.domain.models.transittaxes;


import java.math.BigDecimal;

public class TaxCreation {

    private String refTax;
    private String description;
    private BigDecimal price;
    private Boolean paid;

    public TaxCreation() {
        //empty from framework
    }

    public TaxCreation(String refTax, String description, BigDecimal price, Boolean paid) {
        this.refTax = refTax;
        this.description = description;
        this.price = price;
        this.paid = paid;
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
}
