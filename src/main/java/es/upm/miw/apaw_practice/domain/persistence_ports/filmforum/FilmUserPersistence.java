package es.upm.miw.apaw_practice.domain.persistence_ports.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;

public interface FilmUserPersistence {
    FilmUser findByUsername(String username);
}
