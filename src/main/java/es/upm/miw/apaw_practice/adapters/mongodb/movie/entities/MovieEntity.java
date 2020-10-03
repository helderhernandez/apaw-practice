package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class MovieEntity {
    @Id
    private String id;
    @DBRef
    private FilmDirectorEntity filmDirector;
    @Indexed(unique = true)
    private String filmTitle;
    private LocalDateTime releaseDate;
    private String synopsis;
    private Integer punctuation;

    public MovieEntity() {
        //empty for framework
    }

    public MovieEntity(String filmTitle, FilmDirectorEntity filmDirector, LocalDateTime releaseDate, String synopsis, int punctuation) {
        this.filmTitle = filmTitle;
        this.filmDirector = filmDirector;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.punctuation = punctuation;
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

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public int hashCode() {
        return this.synopsis.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (synopsis.equals(((MovieEntity) obj).synopsis));
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id='" + id + '\'' +
                ", filmDirector=" + filmDirector +
                ", filmTitle='" + filmTitle + '\'' +
                ", releaseDate=" + releaseDate +
                ", synopsis='" + synopsis + '\'' +
                ", punctuation=" + punctuation +
                '}';
    }
}
