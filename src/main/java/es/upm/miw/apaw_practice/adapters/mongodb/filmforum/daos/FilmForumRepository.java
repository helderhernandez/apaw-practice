package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmForumRepository extends MongoRepository<FilmForumEntity, String> {
}
