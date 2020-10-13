package es.upm.miw.apaw_practice.adapters.mongodb.movie.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.CinemaRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.MovieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.MoviePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("moviePersistence")
public class MoviePersistenceMongodb implements MoviePersistence {

    private MovieRepository movieRepository;
    private CinemaRepository cinemaRepository;

    @Autowired
    public MoviePersistenceMongodb(MovieRepository movieRepository, CinemaRepository cinemaRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }

    public void assertFilmTitle(String filmTitle) {
        this.movieRepository
                .findByFilmTitle(filmTitle)
                .ifPresent(article -> {
                    throw new ConflictException("Barcode exist: " + filmTitle);
                });
    }

    @Override
    public Movie create(Movie movie) {
        this.assertFilmTitle(movie.getFilmTitle());
        return this.movieRepository
                .save(new MovieEntity(movie))
                .toMovie();
    }

    @Override
    public void deleteById(String id) {
        this.movieRepository.deleteById(id);
    }

    @Override
    public Stream<Movie> findByCinemaFilmRoomsWithMoreThanNumberOfSeats(Integer numberOfSeats) {
        return this.cinemaRepository.findAll().stream()
                .filter(cinema -> cinema.getFilmRooms().stream()
                            .anyMatch(filmRoomEntity -> filmRoomEntity.getNumberOfSeats() > numberOfSeats))
                .map(CinemaEntity::getMovies)
                .flatMap(movieEntities -> movieEntities.stream())
                .map(MovieEntity::toMovie)
                .distinct();
    }
}
