package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;

public class FilmForumService {
    private FilmForumPersistence filmForumPersistence;

    public FilmForum findByName(String name) {
        return filmForumPersistence.findByName(name);
    }
}
