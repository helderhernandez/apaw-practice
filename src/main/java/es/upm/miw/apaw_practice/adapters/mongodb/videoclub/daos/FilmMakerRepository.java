package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmMakerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmMakerRepository extends MongoRepository<FilmMakerEntity, String> {
}
