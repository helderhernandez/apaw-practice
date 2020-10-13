package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class FilmUserPersistenceMongodbIT {

    @Autowired
    private FilmUserPersistenceMongodb filmUserPersistence;

    @Test
    void testReadByUserName() {
        FilmUser user = filmUserPersistence.findByUsername("acabezas");
        assertEquals(user.getId(), "1");
    }

    @Test
    void testReadByUserNameUserNotFound() {
        assertThrows(NotFoundException.class, () -> filmUserPersistence.findByUsername("NOT_EXISTS"));
    }
}
