package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FilmActorRepository extends MongoRepository<FilmActorEntity, String> {
    Optional<FilmActorEntity> findByNameAndSurname(String name, String surname);

    List<FilmActorEntity> findByName(String name);
}
