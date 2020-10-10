package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategorySportyEntity {

    @Id
    private String idCategory;
    private String description;
    private Integer numMaxPersons;

    public CategorySportyEntity() {
    }

    public CategorySportyEntity(String idCategory, String description, Integer numMaxPersons) {
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
}
