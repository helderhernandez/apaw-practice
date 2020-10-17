package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmUserRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmUserPersistence;
import org.springframework.stereotype.Repository;

@Repository("filmUserPersistence")
public class FilmUserPersistenceMongodb implements FilmUserPersistence {

    private FilmUserRepository filmUserRepository;

    public FilmUserPersistenceMongodb(FilmUserRepository filmUserRepository) {
        this.filmUserRepository = filmUserRepository;
    }

    @Override
    public FilmUser findByUsername(String username) {
        FilmUserEntity user = filmUserRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username " + username + " not found."));
        return user.toFilmUser();
    }
}
