package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class RentalFilmEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String title;
    private Integer year;
    @DBRef
    private FilmMakerEntity filmMaker;
    @DBRef
    private List<FilmCategoryEntity> categories;

    public RentalFilmEntity() {
        // empty from framework
    }

    public RentalFilmEntity(String reference, String title, Integer year, FilmMakerEntity filmMaker, List<FilmCategoryEntity> categories) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.title = title;
        this.year = year;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public RentalFilm toRentalFilm() {
        RentalFilm rentalFilm = new RentalFilm();
        BeanUtils.copyProperties(this, rentalFilm);
        FilmMaker filmMakerM = this.filmMaker.toFilmMaker();
        List<FilmCategory> categoriesM = this.categories.stream()
                .map(FilmCategoryEntity::toFilmCategory)
                .collect(Collectors.toList());
        rentalFilm.setFilmMaker(filmMakerM);
        rentalFilm.setCategories(categoriesM);
        return rentalFilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalFilmEntity rentalFilmEntity = (RentalFilmEntity) o;
        return id.equals(rentalFilmEntity.id) &&
                reference.equals(rentalFilmEntity.reference) &&
                title.equals(rentalFilmEntity.title) &&
                year.equals(rentalFilmEntity.year) &&
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
                ", year=" + year +
                ", filmMaker=" + filmMaker +
                ", categories=" + categories +
                '}';
    }
}
