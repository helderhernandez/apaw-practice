package es.upm.miw.apaw_practice.domain.models.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;

import java.time.LocalDateTime;

public class MovieCreation {
    private FilmDirectorEntity filmDirector;
    private String filmTitle;
    private LocalDateTime releaseDate;
    private String synopsis;
    private Integer punctuation;

    public MovieCreation(){
        //empty for framework
    }

    public MovieCreation(String filmTitle, FilmDirectorEntity filmDirector, LocalDateTime releaseDate, String synopsis, Integer punctuation) {
        this.filmTitle = filmTitle;
        this.filmDirector = filmDirector;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.punctuation = punctuation;
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
                "filmDirector=" + filmDirector +
                ", filmTitle='" + filmTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", synopsis='" + synopsis + '\'' +
                ", punctuation=" + punctuation +
                '}';
    }
}
