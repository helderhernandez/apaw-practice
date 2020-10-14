package es.upm.miw.apaw_practice.domain.persistence_ports.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;

public interface FilmForumPersistence {
    FilmForum findByName(String name);

    FilmForum update(FilmForum film);

    FilmForum getFilmFromComment(FilmComment comment);
}
