package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class FilmCategoryEntity {
    @Id
    private String id;
    private String name;
    private String subName;
    private Boolean plus18;

    public FilmCategoryEntity() {
        // empty from framework
    }

    public FilmCategoryEntity(String id, String name, String subName, Boolean plus18) {
        this.id = id;
        this.name = name;
        this.subName = subName;
        this.plus18 = plus18;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Boolean getPlus18() {
        return plus18;
    }

    public void setPlus18(Boolean plus18) {
        this.plus18 = plus18;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategoryEntity filmCategoryEntity = (FilmCategoryEntity) o;
        return id.equals(filmCategoryEntity.id) &&
                name.equals(filmCategoryEntity.name) &&
                subName.equals(filmCategoryEntity.subName) &&
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
                ", subName='" + subName + '\'' +
                ", plus18=" + plus18 +
                '}';
    }
}
