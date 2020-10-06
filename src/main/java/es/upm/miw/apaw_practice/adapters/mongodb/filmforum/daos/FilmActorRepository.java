package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmActorRepository extends MongoRepository<FilmActorEntity, String> {
}
