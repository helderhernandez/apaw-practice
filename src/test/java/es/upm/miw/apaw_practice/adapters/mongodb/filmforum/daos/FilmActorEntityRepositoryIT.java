package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmActorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class FilmActorEntityRepositoryIT {

    @Autowired
    private FilmActorRepository actorRepository;

    @Test
    void testFindByNameAndSurnameFindsActor() {
        Optional<FilmActorEntity> actor = actorRepository.findByNameAndSurname("actor1", "surname1");
        assertTrue(actor.isPresent());
    }

    @Test
    void testFindByNameAndSurnameDontFindActor() {
        Optional<FilmActorEntity> actor = actorRepository.findByNameAndSurname("actor1", "surname2");
        assertFalse(actor.isPresent());
    }
}
