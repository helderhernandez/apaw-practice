package es.upm.miw.apaw_practice.domain.models.filmforum.composite;

public interface FilmCommentComponentTree {
    String getCommentContent();

    void add(FilmCommentComponentTree component);

    void remove(FilmCommentComponentTree component);
}
