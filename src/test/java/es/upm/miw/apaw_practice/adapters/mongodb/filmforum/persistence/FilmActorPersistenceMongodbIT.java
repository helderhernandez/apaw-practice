package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FilmActorPersistenceMongodbIT {

    @Autowired
    private FilmActorPersistenceMongodb filmActorPersistence;

    @Test
    void testCreation() {
        FilmActorCreation filmActorCreation = new FilmActorCreation("Antonio", "Banderas", 55);
        FilmActor created = filmActorPersistence.create(filmActorCreation);
        assertEquals("Antonio", created.getName());
        assertEquals("Banderas", created.getSurname());
        assertEquals(55, created.getAge());
    }
}
