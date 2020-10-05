package es.upm.miw.apaw_practice.domain.persistence_ports.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.models.movie.MovieCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviePersistence {
    Movie create(MovieCreation movieCreation);

    void deleteById(String id);
}
