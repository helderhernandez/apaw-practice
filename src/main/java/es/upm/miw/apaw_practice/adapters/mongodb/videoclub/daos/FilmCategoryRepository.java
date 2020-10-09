package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmCategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmCategoryRepository extends MongoRepository<FilmCategoryEntity, String> {
}
