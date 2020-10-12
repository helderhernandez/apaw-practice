package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmActorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmActorPersistence;
import org.springframework.stereotype.Repository;

@Repository("filmActorPersistence")
public class FilmActorPersistenceMongodb implements FilmActorPersistence {

    private FilmActorRepository filmActorRepository;

    public FilmActorPersistenceMongodb(FilmActorRepository filmActorRepository) {
        this.filmActorRepository = filmActorRepository;
    }

    @Override
    public FilmActor create(FilmActorCreation actor) {
        return filmActorRepository
                .save(new FilmActorEntity(actor))
                .toFilmActor();
    }
}
