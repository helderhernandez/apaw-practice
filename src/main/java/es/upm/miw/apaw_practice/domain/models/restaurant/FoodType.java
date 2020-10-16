package es.upm.miw.apaw_practice.domain.models.restaurant;

public class FoodType {
    private String id;
    private String type;
    private Boolean spicy;

    public FoodType() {
        //Empty for framework
    }

    public FoodType(String id, Boolean spicy) {
        this.id = id;
        this.spicy = spicy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", spicy=" + spicy +
                '}';
    }
}
