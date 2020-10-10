package es.upm.miw.apaw_practice.domain.persistence_ports.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;

import java.util.List;

public interface FilmForumPersistence {
    List<FilmForum> findByName(String name);
}
