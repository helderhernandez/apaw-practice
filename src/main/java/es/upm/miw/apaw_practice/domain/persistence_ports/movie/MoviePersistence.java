package es.upm.miw.apaw_practice.domain.persistence_ports.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.models.movie.MovieCreation;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository
public interface MoviePersistence {
    Movie create(MovieCreation movieCreation);

    void deleteById(String id);

    Stream<Movie> findByCinemaFilmRoomsWithMoreThanNumberOfSeats(Integer numberOfSeats);
}
