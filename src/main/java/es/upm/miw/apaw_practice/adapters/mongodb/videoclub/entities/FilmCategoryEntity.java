package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class FilmCategoryEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String name;
    private Boolean plus18;

    public FilmCategoryEntity() {
        // empty from framework
    }

    public FilmCategoryEntity(String reference, String name, Boolean plus18) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.name = name;
        this.plus18 = plus18;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public void fromFilmCategory(FilmCategory filmCategory) {
        BeanUtils.copyProperties(filmCategory, this);
    }

    public static Builder builder(String reference) {
        return new Builder(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntity filmCategoryEntity = (FilmCategoryEntity) o;
        return id.equals(filmCategoryEntity.id) &&
                reference.equals(filmCategoryEntity.reference) &&
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
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", plus18=" + plus18 +
                '}';
    }

    public static class Builder {
        private FilmCategoryEntity filmCategoryEntity;

        private Builder(String reference) {
            filmCategoryEntity = new FilmCategoryEntity();
            filmCategoryEntity.setId(UUID.randomUUID().toString());
            filmCategoryEntity.setReference(reference);
        }

        public Builder name(String name) {
            filmCategoryEntity.setName(name);
            return this;
        }

        public Builder plus18(Boolean plus18) {
            filmCategoryEntity.setPlus18(plus18);
            return this;
        }

        public FilmCategoryEntity build() {
            return filmCategoryEntity;
        }
    }
}
