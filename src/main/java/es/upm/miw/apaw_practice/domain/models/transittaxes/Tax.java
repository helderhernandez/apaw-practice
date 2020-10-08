package es.upm.miw.apaw_practice.domain.models.transittaxes;


import java.math.BigDecimal;

public class Tax {

    private String id;
    private String refTaxes;
    private String description;
    private BigDecimal price;
    private Boolean paid;

    public Tax() {
        //empty from framework
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
}
