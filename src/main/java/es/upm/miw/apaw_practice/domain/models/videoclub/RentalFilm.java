package es.upm.miw.apaw_practice.domain.models.videoclub;

import java.util.List;
import java.util.UUID;

public class RentalFilm {

    private String reference;
    private String title;
    private Integer year;
    private FilmMaker filmMaker;
    private List<FilmCategory> categories;

    public RentalFilm() {
        //empty from framework
    }

    public RentalFilm(String reference, String title, Integer year, FilmMaker filmMaker, List<FilmCategory> categories) {
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

    public FilmMaker getFilmMaker() {
        return filmMaker;
    }

    public void setFilmMaker(FilmMaker filmMaker) {
        this.filmMaker = filmMaker;
    }

    public List<FilmCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<FilmCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "RentalFilm{" +
                "reference='" + reference + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", filmMaker=" + filmMaker +
                ", categories=" + categories +
                '}';
    }
}
