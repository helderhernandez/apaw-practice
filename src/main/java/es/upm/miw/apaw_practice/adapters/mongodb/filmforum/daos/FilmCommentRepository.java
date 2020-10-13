package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FilmCommentRepository extends MongoRepository<FilmCommentEntity, String> {
    List<FilmCommentEntity> findByPunctuation(Integer punctuation);

    List<FilmCommentEntity> findByCreatedAt(LocalDateTime createdAt);
}
