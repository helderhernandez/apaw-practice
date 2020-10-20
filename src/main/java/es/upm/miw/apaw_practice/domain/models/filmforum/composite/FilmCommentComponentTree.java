package es.upm.miw.apaw_practice.domain.models.filmforum.composite;

public abstract class FilmCommentComponentTree {
    public abstract String getCommentContent();

    public abstract void add(FilmCommentComponentTree component);

    public abstract void remove(FilmCommentComponentTree component);
}
