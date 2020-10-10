package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmForumRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmForumPersistence;

public class FilmForumPersistenceMongodb implements FilmForumPersistence {

    FilmForumRepository filmForumRepository;

    @Override
    public FilmForum findByName(String name) {
        return filmForumRepository.findByName(name)
                .map(FilmForumEntity::toFilmForum)
                .orElse(null);
    }
}