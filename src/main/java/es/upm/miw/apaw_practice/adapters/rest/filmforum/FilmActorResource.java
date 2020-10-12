package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import es.upm.miw.apaw_practice.domain.services.filmforum.FilmActorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(FilmActorResource.FILMACTOR)
public class FilmActorResource {
    public static final String FILMACTOR = "/filmforum/actors";
    public static final String ACTOR_ID = "/{id}";
    public static final String UPDATE_AGE = "/age";

    private FilmActorService filmActorService;

    public FilmActorResource(FilmActorService filmActorService) {
        this.filmActorService = filmActorService;
    }

    @PostMapping
    public FilmActor create(@RequestBody FilmActorCreation actor) {
        return filmActorService.create(actor);
    }

    @PutMapping(UPDATE_AGE)
    public FilmActor update(@RequestBody FilmActorAgeUpdating actorNameUpdating) {
        return filmActorService.updateAge(actorNameUpdating);
    }
}
