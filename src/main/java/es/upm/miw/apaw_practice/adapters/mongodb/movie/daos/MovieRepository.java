package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<MovieEntity, String> {
    Optional<MovieEntity> findByFilmTitle(String cinemaName);
}
