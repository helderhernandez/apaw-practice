package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import es.upm.miw.apaw_practice.domain.services.filmforum.FilmActorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FilmActorResource.FILMACTOR)
public class FilmActorResource {
    public static final String FILMACTOR = "/filmforum/actor";

    private FilmActorService filmActorService;

    public FilmActorResource(FilmActorService filmActorService) {
        this.filmActorService = filmActorService;
    }

    @PostMapping
    public FilmActor create(@RequestBody FilmActorCreation actor) {
        return filmActorService.create(actor);
    }
}
