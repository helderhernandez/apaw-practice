package es.upm.miw.apaw_practice.domain.models.filmforum;

import java.util.List;

public class FilmForum {
    private String id;
    private List<FilmActor> actors;
    private List<FilmComment> comments;
    private String name;
    private Integer year;
    private Boolean isForAllPublic;
    private Integer duration;
    private String genre;

    public FilmForum(String id, List<FilmActor> actors, List<FilmComment> comments, String name, Integer year, Boolean isForAllPublic, Integer duration, String genre) {
        this.id = id;
        this.actors = actors;
        this.comments = comments;
        this.name = name;
        this.year = year;
        this.isForAllPublic = isForAllPublic;
        this.duration = duration;
        this.genre = genre;
    }

    public List<FilmActor> getActors() {
        return actors;
    }

    public void setActors(List<FilmActor> actors) {
        this.actors = actors;
    }

    public List<FilmComment> getComments() {
        return comments;
    }

    public void setComments(List<FilmComment> comments) {
        this.comments = comments;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FilmForum{" +
                "actors=" + actors +
                ", comments=" + comments +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", isForAllPublic=" + isForAllPublic +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }
}
