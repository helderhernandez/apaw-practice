package es.upm.miw.apaw_practice.adapters.mongodb.movie.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.FilmDirectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.FilmDirectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("filmDirectorPersistence")
public class FilmDirectorPersistenceMongodb implements FilmDirectorPersistence {

    private FilmDirectorRepository filmDirectorRepository;

    @Autowired
    public FilmDirectorPersistenceMongodb(FilmDirectorRepository filmDirectorRepository) {
        this.filmDirectorRepository = filmDirectorRepository;
    }

    @Override
    public Stream<FilmDirector> readAll() {
        return this.filmDirectorRepository.findAll().stream()
                .map(FilmDirectorEntity::toFilmDirector);
    }
}
