package es.upm.miw.apaw_practice.domain.models.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;

import java.time.LocalDateTime;

public class Movie {
    private String id;
    private FilmDirectorEntity filmDirector;
    private String filmTitle;
    private LocalDateTime releaseDate;
    private String synopsis;
    private Integer punctuation;

    public Movie(){
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FilmDirectorEntity getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(FilmDirectorEntity filmDirector) {
        this.filmDirector = filmDirector;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Integer punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", filmDirector=" + filmDirector +
                ", filmTitle='" + filmTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", synopsis='" + synopsis + '\'' +
                ", punctuation=" + punctuation +
                '}';
    }
}
