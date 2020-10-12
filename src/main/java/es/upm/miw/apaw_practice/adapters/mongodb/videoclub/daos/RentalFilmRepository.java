package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.RentalFilmEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RentalFilmRepository extends MongoRepository<RentalFilmEntity, String> {
    Optional<RentalFilmEntity> findByReference(String reference);
}
