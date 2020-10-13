package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(MovieResource.MOVIES)
public class MovieResource {
    static final String MOVIES = "/movie/movies";

    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private MovieService movieService;

    @Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return this.movieService.create(movie);
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.movieService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<Movie> findByCinemaFilmRoomsWithMoreThanNumberOfSeats(@RequestParam String q) {
        Integer numberOfSeats = new LexicalAnalyzer().extractWithAssure(q, "numberOfSeats", Integer::new);
        return this.movieService.findByCinemaFilmRoomsWithMoreThanNumberOfSeats(numberOfSeats);
    }
}
