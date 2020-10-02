package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmDirectorRepository extends MongoRepository<FilmDirectorEntity, String> {
}
