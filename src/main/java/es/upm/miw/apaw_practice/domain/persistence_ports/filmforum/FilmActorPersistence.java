package es.upm.miw.apaw_practice.domain.persistence_ports.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;

public interface FilmActorPersistence {
    FilmActor create(FilmActorCreation actor);

    FilmActor updateAge(FilmActorAgeUpdating actorNameUpdating);
}
