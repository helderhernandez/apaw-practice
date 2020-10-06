package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmUserRepository extends MongoRepository<FilmUserEntity, String> {
}
