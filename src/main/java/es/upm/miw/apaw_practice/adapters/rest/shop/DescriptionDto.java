package es.upm.miw.apaw_practice.adapters.rest.shop;

public class DescriptionDto {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DescriptionDto{" +
                "description='" + description + '\'' +
                '}';
    }
}
