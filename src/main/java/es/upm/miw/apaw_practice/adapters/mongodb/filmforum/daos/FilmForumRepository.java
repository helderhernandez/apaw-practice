package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmCommentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FilmForumRepository extends MongoRepository<FilmForumEntity, String> {
    List<FilmForumEntity> findByYear(Integer year);

    Optional<FilmForumEntity> findByName(String name);

    Optional<FilmForumEntity> findByFilmCommentsContaining(FilmCommentEntity commentEntity);
}
