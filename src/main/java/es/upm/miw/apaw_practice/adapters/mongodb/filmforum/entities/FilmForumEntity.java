package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class FilmForumEntity {
    @Id private String id;
    @DBRef private List<FilmActorEntity> filmActors;
    @DBRef private List<FilmCommentEntity> filmComments;
    private String name;
    private Integer year;
    private Boolean isForAllPublic;
    private Integer duration;
    private String genre;

    public FilmForumEntity() {
        // Framework needs it
    }

    public FilmForumEntity(String id, List<FilmActorEntity> filmActors, List<FilmCommentEntity> filmComments, String name, Integer year, Boolean isForAllPublic, Integer duration, String genre) {
        this.id = id;
        this.filmActors = filmActors;
        this.filmComments = filmComments;
        this.name = name;
        this.year = year;
        this.isForAllPublic = isForAllPublic;
        this.duration = duration;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FilmActorEntity> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(List<FilmActorEntity> filmActors) {
        this.filmActors = filmActors;
    }

    public List<FilmCommentEntity> getFilmComments() {
        return filmComments;
    }

    public void setFilmComments(List<FilmCommentEntity> filmComments) {
        this.filmComments = filmComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getForAllPublic() {
        return isForAllPublic;
    }

    public void setForAllPublic(Boolean forAllPublic) {
        isForAllPublic = forAllPublic;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((FilmForumEntity) obj).id));
    }

    @Override
    public String toString() {
        return "FilmForumEntity{" +
                "id='" + id + '\'' +
                ", filmActors=" + filmActors +
                ", filmComments=" + filmComments +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", isForAllPublic=" + isForAllPublic +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }
}
