package es.upm.miw.apaw_practice.domain.services.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.persistence_ports.movie.MoviePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MovieService {

    private MoviePersistence moviePersistence;

    @Autowired
    public MovieService(MoviePersistence moviePersistence) {
        this.moviePersistence = moviePersistence;
    }

    public Movie create(Movie movie) {
        return this.moviePersistence.create(movie);
    }

    public void delete(String id) {
        this.moviePersistence.deleteById(id);
    }

    public Stream<Movie> findByCinemaFilmRoomsWithMoreThanNumberOfSeats(Integer numberOfSeats) {
        return this.moviePersistence.findByCinemaFilmRoomsWithMoreThanNumberOfSeats(numberOfSeats);
    }
}
