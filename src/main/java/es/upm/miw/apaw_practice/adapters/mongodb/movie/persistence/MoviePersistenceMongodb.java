package es.upm.miw.apaw_practice.adapters.mongodb.movie.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.MovieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.models.movie.MovieCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.MoviePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("moviePersistence")
public class MoviePersistenceMongodb implements MoviePersistence {

    private MovieRepository movieRepository;

    @Autowired
    public MoviePersistenceMongodb(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void assertFilmTitle(String filmTitle) {
        this.movieRepository
                .findByFilmTitle(filmTitle)
                .ifPresent(article -> {
                    throw new ConflictException("Barcode exist: " + filmTitle);
                });
    }

    @Override
    public Movie create(MovieCreation movieCreation) {
        this.assertFilmTitle(movieCreation.getFilmTitle());
        return this.movieRepository
                .save(new MovieEntity(movieCreation))
                .toMovie();
    }

    @Override
    public void deleteById(String id) {
        this.movieRepository.deleteById(id);
    }
}
