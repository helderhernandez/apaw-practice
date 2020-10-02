package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.services.movie.FilmDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(FilmDirectorResource.FILMDIRECTORS)
public class FilmDirectorResource {
    static final String FILMDIRECTORS = "/movie/filmDirectors";

    static final String SEARCH = "/search";

    private FilmDirectorService filmDirectorService;

    @Autowired
    public FilmDirectorResource(FilmDirectorService filmDirectorService) {
        this.filmDirectorService = filmDirectorService;
    }

    @GetMapping
    public Stream<FilmDirector> readAll() {
        return this.filmDirectorService.readAll();
    }
}
