package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CategorySporty;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

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

    public CategorySportyEntity(CategoryCreationSporty categoryCreationSporty) {
        BeanUtils.copyProperties(categoryCreationSporty, this);
        this.idCategory = UUID.randomUUID().toString();
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

    public CategorySporty convertToCategorySporty() {
        return new CategorySporty(this.idCategory, this.description, this.numMaxPersons);
    }

    @Override
    public String toString() {
        return "CategorySportyEntity{" +
                "idCategory='" + idCategory + '\'' +
                ", description='" + description + '\'' +
                ", numMaxPersons=" + numMaxPersons +
                '}';
    }
}
