package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.models.movie.MovieCreation;
import es.upm.miw.apaw_practice.domain.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MovieResource.MOVIES)
public class MovieResource {
    static final String MOVIES = "/movie/movies";

    static final String ID_ID = "/{id}";

    private MovieService movieService;

    @Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie create(@RequestBody MovieCreation movieCreation) {
        return this.movieService.create(movieCreation);
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.movieService.delete(id);
    }
}
