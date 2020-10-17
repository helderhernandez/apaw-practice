package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import es.upm.miw.apaw_practice.domain.services.videoclub.FilmMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilmMakerResource.FILMMAKERS)
public class FilmMakerResource {
    static final String FILMMAKERS = "/videoclub/films_makers";

    private FilmMakerService filmMakerService;

    @Autowired
    public FilmMakerResource(FilmMakerService filmMakerService) {
        this.filmMakerService = filmMakerService;
    }

    @PostMapping
    public FilmMaker create(@RequestBody FilmMaker filmMaker) {
        return this.filmMakerService.create(filmMaker);
    }
}
