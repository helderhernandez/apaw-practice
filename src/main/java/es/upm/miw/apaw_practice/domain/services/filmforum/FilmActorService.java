package es.upm.miw.apaw_practice.domain.services.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmActorPersistence;
import org.springframework.stereotype.Service;

@Service
public class FilmActorService {

    private FilmActorPersistence filmActorPersistence;

    public FilmActorService(FilmActorPersistence filmActorPersistence) {
        this.filmActorPersistence = filmActorPersistence;
    }

    public FilmActor create(FilmActorCreation filmActorCreation) {
        return this.filmActorPersistence.create(filmActorCreation);
    }

    public FilmActor updateAge(FilmActorAgeUpdating actorNameUpdating) {
        return this.filmActorPersistence.updateAge(actorNameUpdating);
    }
}
