package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CinemaRepository extends MongoRepository<CinemaEntity, String> {
    Optional<CinemaEntity> findByCinemaName(String cinemaName);
}
