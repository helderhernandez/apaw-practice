package es.upm.miw.apaw_practice.domain.services.movie;

import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.FilmDirectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FilmDirectorService {

    private FilmDirectorPersistence filmDirectorPersistence;

    @Autowired
    public FilmDirectorService(FilmDirectorPersistence filmDirectorPersistence) {
        this.filmDirectorPersistence = filmDirectorPersistence;
    }

    public Stream<FilmDirector> readAll() {
        return this.filmDirectorPersistence.readAll();
    }
}
