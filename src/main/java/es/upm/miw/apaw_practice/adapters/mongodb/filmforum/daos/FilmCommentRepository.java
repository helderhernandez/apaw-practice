package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmCommentRepository extends MongoRepository<FilmCommentEntity, String> {
}
