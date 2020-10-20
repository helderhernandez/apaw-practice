package es.upm.miw.apaw_practice.domain.models.sportyrental;

public class CategoryCreationSporty {
    private String description;
    private Integer numMaxPersons;

    public CategoryCreationSporty() {
        //empty for framework
    }

    public CategoryCreationSporty(String description, Integer numMaxPersons) {
        this.description = description;
        this.numMaxPersons = numMaxPersons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumMaxPersons() {
        return numMaxPersons;
    }

    public void setNumMaxPersons(Integer numMaxPersons) {
        this.numMaxPersons = numMaxPersons;
    }

    @Override
    public String toString() {
        return "CategoryCreationSporty{" +
                ", description='" + description + '\'' +
                ", numMaxPersons=" + numMaxPersons +
                '}';
    }
}
