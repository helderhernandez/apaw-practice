package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testCreateAndUpdate() {
        FilmActorCreation filmActorCreation = new FilmActorCreation("Morgan", "Freeman", 20);
        FilmActor created = filmActorPersistence.create(filmActorCreation);
        FilmActorAgeUpdating newAge = new FilmActorAgeUpdating("Morgan", "Freeman", 70);
        FilmActor updated = filmActorPersistence.updateAge(newAge);
        assertEquals(created.getName(), updated.getName());
        assertEquals(created.getSurname(), updated.getSurname());
        assertEquals(updated.getAge(), newAge.getAge());
    }

    @Test
    void testCreateAndUpdateIdNotFound() {
        assertThrows(NotFoundException.class, () -> filmActorPersistence.updateAge(new FilmActorAgeUpdating("NOT", "FOUND", 0)));
    }

    @Test
    void testFindActorByName() {
        List<FilmActor> actors = filmActorPersistence.findByName("actor4");
        assertEquals(actors.size(), 2);
    }

    @Test
    void testFindActorByNameNoActorWithThatName() {
        List<FilmActor> actors = filmActorPersistence.findByName("Somebody");
        assertTrue(actors.isEmpty());
    }
}
