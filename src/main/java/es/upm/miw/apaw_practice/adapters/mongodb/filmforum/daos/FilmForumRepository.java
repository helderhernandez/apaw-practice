package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilmForumRepository extends MongoRepository<FilmForumEntity, String> {
    List<FilmForumEntity> findByYear(Integer year);
}
