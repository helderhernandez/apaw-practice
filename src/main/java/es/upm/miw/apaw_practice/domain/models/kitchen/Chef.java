package es.upm.miw.apaw_practice.domain.models.kitchen;

import java.util.List;

public class Chef {
    private String id;
    private String dni;
    private Integer recipesFinished;
    private List<String> kitchenBoyDnis;

    public Chef() {
        //Empty from framework
    }

    public Chef(String id, String dni, Integer recipesFinished, List<String> kitchenBoyDnis) {
        this.id = id;
        this.dni = dni;
        this.recipesFinished = recipesFinished;
        this.kitchenBoyDnis = kitchenBoyDnis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getRecipesFinished() {
        return recipesFinished;
    }

    public void setRecipesFinished(Integer recipesFinished) {
        this.recipesFinished = recipesFinished;
    }

    public List<String> getKitchenBoyDnis() {
        return kitchenBoyDnis;
    }

    public void setKitchenBoyDnis(List<String> kitchenBoyDnis) {
        this.kitchenBoyDnis = kitchenBoyDnis;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "id='" + id + '\'' +
                ", dni=" + dni + '\'' +
                ", recipesFinished=" + recipesFinished + '\'' +
                ", kitchenBoyDnis=" + kitchenBoyDnis + '\'' +
                '}';
    }
}
