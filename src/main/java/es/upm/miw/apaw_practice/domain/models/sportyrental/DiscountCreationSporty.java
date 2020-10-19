package es.upm.miw.apaw_practice.domain.models.sportyrental;

public class DiscountCreationSporty {

    private String description;
    private Double percentage;

    public DiscountCreationSporty() {
        //empty for framework
    }

    public DiscountCreationSporty(String description, Double percentage) {
        this.description = description;
        this.percentage = percentage;
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
        return "DiscountCreationSporty{" +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
