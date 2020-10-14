package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos.FilmActorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.filmforum.FilmActorPersistence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public FilmActor updateAge(FilmActorAgeUpdating actorNameUpdating) {
        FilmActorEntity actorFromDB = filmActorRepository.findByNameAndSurname(actorNameUpdating.getName(), actorNameUpdating.getSurname())
                .orElseThrow(() -> new NotFoundException("Actor with name " + actorNameUpdating.getName() +
                        " and surname " + actorNameUpdating.getSurname() + " not found."));

        actorFromDB.setAge(actorNameUpdating.getAge());
        return filmActorRepository.save(actorFromDB).toFilmActor();
    }

    @Override
    public List<FilmActor> findByName(String name) {
        return filmActorRepository.findByName(name).stream()
                .map(FilmActorEntity::toFilmActor)
                .collect(Collectors.toList());
    }
}
