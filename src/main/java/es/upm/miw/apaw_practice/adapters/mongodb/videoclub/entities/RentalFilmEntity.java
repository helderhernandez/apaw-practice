package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class RentalFilmEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String title;
    private String description;
    private Integer year;
    private Integer duration;
    @DBRef
    private FilmMakerEntity filmMaker;
    @DBRef
    private List<FilmCategoryEntity> categories;

    public RentalFilmEntity() {
        // empty from framework
    }

    public RentalFilmEntity(String reference, String title, String description, Integer year, Integer duration, FilmMakerEntity filmMaker, List<FilmCategoryEntity> categories) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.title = title;
        this.description = description;
        this.year = year;
        this.duration = duration;
        this.filmMaker = filmMaker;
        this.categories = categories;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public FilmMakerEntity getFilmMaker() {
        return filmMaker;
    }

    public void setFilmMaker(FilmMakerEntity filmMaker) {
        this.filmMaker = filmMaker;
    }

    public List<FilmCategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<FilmCategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalFilmEntity rentalFilmEntity = (RentalFilmEntity) o;
        return id.equals(rentalFilmEntity.id) &&
                reference.equals(rentalFilmEntity.reference) &&
                title.equals(rentalFilmEntity.title) &&
                description.equals(rentalFilmEntity.description) &&
                year.equals(rentalFilmEntity.year) &&
                duration.equals(rentalFilmEntity.duration) &&
                filmMaker.equals(rentalFilmEntity.filmMaker) &&
                categories.equals(rentalFilmEntity.categories);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "RentalFilmEntity{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", filmMaker=" + filmMaker +
                ", categories=" + categories +
                '}';
    }
}
