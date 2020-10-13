package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FilmCategoryEntity {
    @Id
    private String id;
    private String name;
    private Boolean plus18;

    public FilmCategoryEntity() {
        // empty from framework
    }

    public FilmCategoryEntity(String id, String name, Boolean plus18) {
        this.id = id;
        this.name = name;
        this.plus18 = plus18;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPlus18() {
        return plus18;
    }

    public void setPlus18(Boolean plus18) {
        this.plus18 = plus18;
    }

    public FilmCategory toFilmCategory() {
        FilmCategory filmCategory = new FilmCategory();
        BeanUtils.copyProperties(this, filmCategory);
        return filmCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntity filmCategoryEntity = (FilmCategoryEntity) o;
        return id.equals(filmCategoryEntity.id) &&
                name.equals(filmCategoryEntity.name) &&
                plus18.equals(filmCategoryEntity.plus18);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FilmCategoryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", plus18=" + plus18 +
                '}';
    }
}
