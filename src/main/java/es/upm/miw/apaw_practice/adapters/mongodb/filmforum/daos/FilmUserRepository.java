package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FilmUserRepository extends MongoRepository<FilmUserEntity, String> {
    Optional<FilmUserEntity> findByUsername(String username);
}
