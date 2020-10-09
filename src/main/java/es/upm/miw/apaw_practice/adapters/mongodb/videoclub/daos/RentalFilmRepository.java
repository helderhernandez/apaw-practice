package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.RentalFilmEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalFilmRepository extends MongoRepository<RentalFilmEntity, String> {
}
