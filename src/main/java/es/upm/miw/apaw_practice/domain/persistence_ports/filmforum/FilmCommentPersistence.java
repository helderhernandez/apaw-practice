package es.upm.miw.apaw_practice.domain.persistence_ports.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;

import java.util.List;

public interface FilmCommentPersistence {
    void delete(String id);

    List<FilmComment> findCommentsByUser(FilmUser user);
}

