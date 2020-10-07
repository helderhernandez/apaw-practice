package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FilmCommentRepository extends MongoRepository<FilmCommentEntity, String> {
    Optional<List<FilmCommentEntity>> findByPunctuation(Integer punctuation);
    Optional<List<FilmCommentEntity>> findByCreatedAt(LocalDateTime createdAt);
}
