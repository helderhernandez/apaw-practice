package es.upm.miw.apaw_practice.domain.persistence_ports.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MoviePersistence {
    Movie create(Movie movie);

    void deleteById(String id);

    Stream<Movie> findByCinemaFilmRoomsWithMoreThanNumberOfSeats(Integer numberOfSeats);
}
