package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestConfig
public class FilmForumPersistenceMongodbIT {

    @Autowired
    private FilmForumPersistenceMongodb filmForumPersistence;

    @Test
    void testReadByNameNameNotFound() {
        assertThrows(NotFoundException.class, () -> filmForumPersistence.findByName("Name_Not_found"));
    }

    @Test
    void testReadByNameWhenNameIsBadFormatted() {
        assertThrows(NotFoundException.class, () -> filmForumPersistence.findByName(null));
    }

    @Test
    void testReadByNameNameFound() {
        assertDoesNotThrow(() -> filmForumPersistence.findByName("film1"));
    }
}
