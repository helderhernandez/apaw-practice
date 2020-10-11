package es.upm.miw.apaw_practice.domain.models.sportyRental;

public class DiscountSporty {

    private String idDiscount;
    private String description;
    private Double percentage;

    public DiscountSporty() {
    }

    public DiscountSporty(String idDiscount, String description, Double percentage) {
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
        return "DiscountSporty{" +
                "idDiscount='" + idDiscount + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
