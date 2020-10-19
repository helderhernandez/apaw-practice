package es.upm.miw.apaw_practice.adapters.rest.restaurant;

public class FoodTypeDto {
    String id;

    public FoodTypeDto() {
        //Empty for framework
    }

    public FoodTypeDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FoodTypeDto{" +
                "name='" + id + '\'' +
                '}';
    }
}
