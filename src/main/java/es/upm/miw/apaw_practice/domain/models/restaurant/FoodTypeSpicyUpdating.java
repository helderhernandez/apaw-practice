package es.upm.miw.apaw_practice.domain.models.restaurant;

public class FoodTypeSpicyUpdating {
    private String id;
    private Boolean spicy;

    public FoodTypeSpicyUpdating() {
        //Empty for framework
    }

    public FoodTypeSpicyUpdating(String id, Boolean spicy) {
        this.id = id;
        this.spicy = spicy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSpicy() {
        return spicy;
    }

    public void setSpicy(Boolean spicy) {
        this.spicy = spicy;
    }

    @Override
    public String toString() {
        return "FoodTypeSpicyUpdating{" +
                "id='" + id + '\'' +
                ", spicy=" + spicy +
                '}';
    }
}
