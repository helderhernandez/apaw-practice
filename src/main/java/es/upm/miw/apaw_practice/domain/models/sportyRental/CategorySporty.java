package es.upm.miw.apaw_practice.domain.models.sportyRental;

public class CategorySporty {

    private String idCategory;
    private String description;
    private Integer numMaxPersons;

    public CategorySporty() {
    }

    public CategorySporty(String idCategory, String description, Integer numMaxPersons) {
        this.idCategory = idCategory;
        this.description = description;
        this.numMaxPersons = numMaxPersons;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
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
        return "CategorySporty{" +
                "idCategory='" + idCategory + '\'' +
                ", description='" + description + '\'' +
                ", numMaxPersons=" + numMaxPersons +
                '}';
    }
}
