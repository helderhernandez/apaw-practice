package es.upm.miw.apaw_practice.adapters.rest.kitchen;

public class ChefDto {
    private String dni;
    private Integer recipesFinished;

    public ChefDto() {
        //Empty from framework
    }

    public ChefDto(String dni, Integer recipesFinished) {
        this.dni = dni;
        this.recipesFinished = recipesFinished;
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

    @Override
    public String toString() {
        return "ChefDto{" +
                "dni=" + dni + '\'' +
                ", recipesFinished=" + recipesFinished + '\'' +
                '}';
    }
}
