package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class FilmCommentPersistenceMongodbIT {

    @Autowired
    private FilmCommentPersistenceMongodb filmCommentPersistence;

    @Test
    void testDeleteByIdCommentNotFound() {
        assertThrows(NotFoundException.class, () -> filmCommentPersistence.delete("NOT_FOUND"));
    }

    @Test
    void testDeleteCommentSuccess() {
        assertDoesNotThrow(() -> filmCommentPersistence.delete("5"));
    }
}
