package es.upm.miw.apaw_practice.domain.persistence_ports.movie;

import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FilmDirectorPersistence {
    Stream<FilmDirector> readAll();

    FilmDirector updateAge(String id, Integer age);
}
